/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.lsp.client.debugger.breakpoints;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import org.netbeans.api.debugger.Breakpoint;
import org.netbeans.api.debugger.Breakpoint.VALIDITY;
import org.netbeans.api.debugger.DebuggerManager;
import org.netbeans.api.debugger.DebuggerManagerAdapter;

import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.text.Annotation;
import org.openide.text.AnnotationProvider;
import org.openide.text.Line;
import org.openide.util.Lookup;
import org.openide.util.RequestProcessor;


/**
 * This class is called when some file in editor is opened. It changes if
 * some breakpoints are added or removed.
 *
 */
@org.openide.util.lookup.ServiceProvider(service=org.openide.text.AnnotationProvider.class)
public final class BreakpointAnnotationProvider extends DebuggerManagerAdapter implements AnnotationProvider {

    private final Map<DAPLineBreakpoint, Set<Annotation>> breakpointToAnnotations = new IdentityHashMap<>();
    private final Set<FileObject> annotatedFiles = Collections.newSetFromMap(new WeakHashMap<>());
    private volatile boolean breakpointsActive = true;
    private final RequestProcessor annotationProcessor = new RequestProcessor("CPP BP Annotation Refresh", 1);

    public BreakpointAnnotationProvider() {
        DebuggerManager.getDebuggerManager().addDebuggerListener(DebuggerManager.PROP_BREAKPOINTS, this);
    }

    @Override
    public void annotate (Line.Set set, Lookup lookup) {
        final FileObject fo = lookup.lookup(FileObject.class);
        if (fo != null) {
            DataObject dobj = lookup.lookup(DataObject.class);
            if (dobj != null) {
                PropertyChangeListener pchl = new PropertyChangeListener() {
                    /** annotate renamed files. */
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        if (DataObject.PROP_PRIMARY_FILE.equals(evt.getPropertyName())) {
                            DataObject dobj = (DataObject) evt.getSource();
                            final FileObject newFO = dobj.getPrimaryFile();
                            annotationProcessor.post(new Runnable() {
                                @Override
                                public void run() {
                                    annotate(newFO);
                                }
                            });
                        }
                    }
                };
                dobj.addPropertyChangeListener(pchl);
            }
            annotate(fo);
        }
    }

    private void annotate (final FileObject fo) {
        synchronized (breakpointToAnnotations) {
            for (Breakpoint breakpoint : DebuggerManager.getDebuggerManager().getBreakpoints()) {
                if (breakpoint instanceof DAPLineBreakpoint) {
                    DAPLineBreakpoint b = (DAPLineBreakpoint) breakpoint;
                    if (!b.isHidden() && isAt(b, fo)) {
                        if (!breakpointToAnnotations.containsKey(b)) {
                            b.addPropertyChangeListener(this);
                        }
                        removeAnnotations(b);   // Remove any staled breakpoint annotations
                        addAnnotationTo(b);
                    }
                }
            }
            annotatedFiles.add(fo);
        }
    }

    private static boolean isAt(DAPLineBreakpoint b, FileObject fo) {
        FileObject bfo = b.getFileObject();
        return fo.equals(bfo);
    }

    @Override
    public void breakpointAdded(Breakpoint breakpoint) {
        if (breakpoint instanceof DAPLineBreakpoint && !((DAPLineBreakpoint) breakpoint).isHidden()) {
            postAnnotationRefresh((DAPLineBreakpoint) breakpoint, false, true);
            breakpoint.addPropertyChangeListener (this);
        }
    }

    @Override
    public void breakpointRemoved(Breakpoint breakpoint) {
        if (breakpoint instanceof DAPLineBreakpoint && !((DAPLineBreakpoint) breakpoint).isHidden()) {
            breakpoint.removePropertyChangeListener (this);
            postAnnotationRefresh((DAPLineBreakpoint) breakpoint, true, false);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object source = evt.getSource();
        if (source instanceof DAPLineBreakpoint) {
            String propertyName = evt.getPropertyName ();
            switch (propertyName) {
                case Breakpoint.PROP_ENABLED:
                case Breakpoint.PROP_VALIDITY:
                case DAPLineBreakpoint.PROP_CONDITION:
                    postAnnotationRefresh((DAPLineBreakpoint) source, true, true);
            }
        }
    }

    void setBreakpointsActive(boolean active) {
        if (breakpointsActive == active) {
            return ;
        }
        breakpointsActive = active;
        annotationProcessor.post(new AnnotationRefresh(null, true, true));
    }

    private void postAnnotationRefresh(DAPLineBreakpoint b, boolean remove, boolean add) {
        annotationProcessor.post(new AnnotationRefresh(b, remove, add));
    }

    private final class AnnotationRefresh implements Runnable {

        private final DAPLineBreakpoint b;
        private final boolean remove;
        private final boolean add;

        public AnnotationRefresh(DAPLineBreakpoint b, boolean remove, boolean add) {
            this.b = b;
            this.remove = remove;
            this.add = add;
        }

        @Override
        public void run() {
            synchronized (breakpointToAnnotations) {
                if (b != null) {
                    refreshAnnotation(b);
                } else {
                    List<DAPLineBreakpoint> bpts = new ArrayList<>(breakpointToAnnotations.keySet());
                    for (DAPLineBreakpoint bp : bpts) {
                        refreshAnnotation(bp);
                    }
                }
            }
        }

        private void refreshAnnotation(DAPLineBreakpoint b) {
            assert Thread.holdsLock(breakpointToAnnotations);
            removeAnnotations(b);
            if (remove) {
                if (!add) {
                    breakpointToAnnotations.remove(b);
                }
            }
            if (add) {
                breakpointToAnnotations.put(b, Collections.newSetFromMap(new WeakHashMap<>()));
                for (FileObject fo : annotatedFiles) {
                    if (isAt(b, fo)) {
                        addAnnotationTo(b);
                    }
                }
            }
        }

    }

    private static String getAnnotationType(DAPLineBreakpoint b, boolean isConditional,
                                            boolean active) {
        boolean isInvalid = b.getValidity() == VALIDITY.INVALID;
        String annotationType = b.isEnabled() ?
                (isConditional ? DebuggerBreakpointAnnotation.CONDITIONAL_BREAKPOINT_ANNOTATION_TYPE :
                                 DebuggerBreakpointAnnotation.BREAKPOINT_ANNOTATION_TYPE) :
                (isConditional ? DebuggerBreakpointAnnotation.DISABLED_CONDITIONAL_BREAKPOINT_ANNOTATION_TYPE :
                                 DebuggerBreakpointAnnotation.DISABLED_BREAKPOINT_ANNOTATION_TYPE);
        if (!active) {
            annotationType += "_stroke";                    // NOI18N
        } else if (isInvalid && b.isEnabled ()) {
            annotationType += "_broken";                    // NOI18N
        }
        return annotationType;
    }

    private void addAnnotationTo(DAPLineBreakpoint b) {
        assert Thread.holdsLock(breakpointToAnnotations);
        String condition = getCondition(b);
        boolean isConditional = condition.trim().length() > 0 || b.getHitCountFilteringStyle() != null;
        String annotationType = getAnnotationType(b, isConditional, breakpointsActive);
        DebuggerBreakpointAnnotation annotation = DebuggerBreakpointAnnotation.create(annotationType, b);
        if (annotation == null) {
            return ;
        }
        Set<Annotation> bpAnnotations = breakpointToAnnotations.get(b);
        if (bpAnnotations == null) {
            Set<Annotation> set = Collections.newSetFromMap(new WeakHashMap<>());
            set.add(annotation);
            breakpointToAnnotations.put(b, set);
        } else {
            bpAnnotations.add(annotation);
            breakpointToAnnotations.put(b, bpAnnotations);
        }
    }

    private void removeAnnotations(DAPLineBreakpoint b) {
        assert Thread.holdsLock(breakpointToAnnotations);
        Set<Annotation> annotations = breakpointToAnnotations.remove(b);
        if (annotations == null) {
            return ;
        }
        for (Annotation a : annotations) {
            a.detach();
        }
    }

    /**
     * Gets the condition of a breakpoint.
     * @param b The breakpoint
     * @return The condition or empty {@link String} if no condition is supported.
     */
    static String getCondition(Breakpoint b) {
        if (b instanceof DAPLineBreakpoint) {
            return ""; // TODO
        } else {
            throw new IllegalStateException(b.toString());
        }
    }
}
