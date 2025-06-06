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

package org.netbeans.modules.profiler.projectsupport.utilities;

import org.netbeans.api.java.classpath.*;
import org.netbeans.api.java.platform.*;
import org.openide.*;
import org.openide.filesystems.*;
import org.openide.modules.SpecificationVersion;
import org.openide.util.*;
import java.io.*;
import java.net.*;
import java.util.*;


/**
 * Support for execution of applets.
 *
 * @author Tomas Hurka
 * @author Ales Novak, Martin Grebac
 */
@NbBundle.Messages({
    "GEN_title=Applet HTML Page",
    "GEN_header=Applet HTML Page",
    "GEN_copy=Generated by NetBeans IDE",
    "GEN_warning=<!--\n" +
    "*** GENERATED applet HTML launcher - DO NOT EDIT IN 'BUILD' FOLDER ***\n\n" +
    "If you need to modify this HTML launcher file (e.g., to add applet parameters), \n" +
    "copy it to where your applet class is found in the SRC folder. If you do this, \n"  +
    "the IDE will use it when you run or debug the applet.\n\n" +
    "Tip: To exclude an HTML launcher from the JAR file, use exclusion filters in \n" +
    "the Creating JAR page in the Project Properties dialog.\n\n" +
    "For more information see the online help.\n" +
    "-->\n\n"
})
public class AppletSupport {
    //~ Static fields/initializers -----------------------------------------------------------------------------------------------

    // JDK issue #6193279: Appletviewer does not accept encoded URLs
    private static final SpecificationVersion JDK_15 = new SpecificationVersion("1.5"); // NOI18N

    /**
     * constant for html extension
     */
    private static final String HTML_EXT = "html"; // NOI18N

    /**
     * constant for class extension
     */
    private static final String CLASS_EXT = "class"; // NOI18N
    private static final String POLICY_FILE_NAME = "applet"; // NOI18N
    private static final String POLICY_FILE_EXT = "policy"; // NOI18N

    // Used only from unit tests to suppress detection of applet. If value
    // is different from null it will be returned instead.
    public static Boolean unitTestingSupport_isApplet = null;

    //~ Constructors -------------------------------------------------------------------------------------------------------------

    private AppletSupport() {
    }

    //~ Methods ------------------------------------------------------------------------------------------------------------------

//    public static boolean isApplet(FileObject file) {
//        if (file == null) {
//            return false;
//        }
//
//        // support for unit testing
//        if (unitTestingSupport_isApplet != null) {
//            return unitTestingSupport_isApplet.booleanValue();
//        }
//
//        return SourceUtils.isApplet(file);
//    }

    /**
     * @return URL of the html file with the same name as sibling
     */
    public static URL generateHtmlFileURL(FileObject appletFile, FileObject buildDir, FileObject classesDir, String activePlatform)
                                   throws FileStateInvalidException {
        FileObject html = null;
        IOException ex = null;

        if ((appletFile == null) || (buildDir == null) || (classesDir == null)) {
            return null;
        }

        try {
            html = generateHtml(appletFile, buildDir, classesDir);
        } catch (IOException iex) {
            ex = iex;
        }

        URL url = null;

        if (ex == null) {
            // JDK issue #6193279: Appletviewer does not accept encoded URLs
            JavaPlatformManager pm = JavaPlatformManager.getDefault();
            JavaPlatform platform = null;

            if (activePlatform == null) {
                platform = pm.getDefaultPlatform();
            } else {
                JavaPlatform[] installedPlatforms = pm.getPlatforms(null, new Specification("j2se", null)); //NOI18N

                for (int i = 0; i < installedPlatforms.length; i++) {
                    String antName = installedPlatforms[i].getProperties().get("platform.ant.name"); //NOI18N

                    if ((antName != null) && antName.equals(activePlatform)) {
                        platform = installedPlatforms[i];

                        break;
                    }
                }
            }

            boolean workAround6193279 = (platform != null //In case of nonexisting platform don't use the workaround
            ) && (platform.getSpecification().getVersion().compareTo(JDK_15) >= 0); //JDK1.5 and higher

            if (workAround6193279) {
                File f = FileUtil.toFile(html);

                try {
                    url = new URL("file", null, f.getAbsolutePath()); // NOI18N
                } catch (MalformedURLException e) {
                    ErrorManager.getDefault().notify(e);
                }
            } else {
                url = html.toURL();
            }
        }

        return url;
    }

    /**
     * @return html file with the same name as applet
     */
    public static FileObject generateSecurityPolicy(FileObject projectDir, FileObject buildDir) {
        FileObject policyFile = buildDir.getFileObject(POLICY_FILE_NAME, POLICY_FILE_EXT);

        try {
            if (policyFile == null) {
                FileObject original = projectDir.getFileObject(POLICY_FILE_NAME, POLICY_FILE_EXT);

                if (original != null) {
                    policyFile = FileUtil.copyFile(original, buildDir, POLICY_FILE_NAME, POLICY_FILE_EXT);
                } else {
                    policyFile = buildDir.createData(POLICY_FILE_NAME, POLICY_FILE_EXT);

                    FileLock lock = policyFile.lock();
                    PrintWriter writer = null;

                    try {
                        writer = new PrintWriter(policyFile.getOutputStream(lock));
                        fillInPolicyFile(writer);
                    } finally {
                        lock.releaseLock();

                        if (writer != null) {
                            writer.close();
                        }
                    }
                }
            }
        } catch (IOException ioe) {
            ErrorManager.getDefault().log(ErrorManager.INFORMATIONAL, "Failed to generate applet policy file: " + ioe); //NOI18N
        }

        return policyFile;
    }

    /**
     * fills in file with html source so it is html file with applet
     *
     * @param name is name of the applet
     */
    private static void fillInFile(PrintWriter writer, String name, String codebase) {
        writer.println("<HTML>"); // NOI18N
        writer.println("<HEAD>"); // NOI18N

        writer.print("   <TITLE>"); // NOI18N
        writer.print(Bundle.GEN_title());
        writer.println("</TITLE>"); // NOI18N

        writer.println("</HEAD>"); // NOI18N
        writer.println("<BODY>\n"); // NOI18N

        writer.print(Bundle.GEN_warning());

        writer.print("<H3><HR WIDTH=\"100%\">"); // NOI18N
        writer.print(Bundle.GEN_header());
        writer.println("<HR WIDTH=\"100%\"></H3>\n"); // NOI18N

        writer.println("<P>"); // NOI18N
                               //        String codebase = getCodebase (name);

        if (codebase == null) {
            writer.print("<APPLET code="); // NOI18N
        } else {
            writer.print("<APPLET " + codebase + " code="); // NOI18N
        }

        writer.print("\""); // NOI18N

        writer.print(name);
        writer.print("\""); // NOI18N

        writer.println(" width=350 height=200></APPLET>"); // NOI18N
        writer.println("</P>\n"); // NOI18N

        writer.print("<HR WIDTH=\"100%\"><FONT SIZE=-1><I>"); // NOI18N
        writer.print(Bundle.GEN_copy());
        writer.println("</I></FONT>"); // NOI18N

        writer.println("</BODY>"); // NOI18N
        writer.println("</HTML>"); // NOI18N
        writer.flush();
    }

    /**
     * fills in policy file with all permissions granted
     *
     * @param writer is a file to be filled
     */
    private static void fillInPolicyFile(PrintWriter writer) {
        writer.println("grant {"); // NOI18N
        writer.println("permission java.security.AllPermission;"); // NOI18N
        writer.println("};"); // NOI18N
        writer.flush();
    }

    /**
     * @return html file with the same name as applet
     */
    private static FileObject generateHtml(FileObject appletFile, FileObject buildDir, FileObject classesDir)
                                    throws IOException {
        FileObject htmlFile = buildDir.getFileObject(appletFile.getName(), HTML_EXT);

        if (htmlFile == null) {
            htmlFile = buildDir.createData(appletFile.getName(), HTML_EXT);
        }

        FileLock lock = htmlFile.lock();
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(htmlFile.getOutputStream(lock));

            ClassPath cp = ClassPath.getClassPath(appletFile, ClassPath.EXECUTE);
            ClassPath sp = ClassPath.getClassPath(appletFile, ClassPath.SOURCE);
            String path = FileUtil.getRelativePath(sp.findOwnerRoot(appletFile), appletFile);
            path = path.substring(0, path.length() - 5);
            fillInFile(writer, path + "." + CLASS_EXT, "codebase=\"" + classesDir.toURL() + "\""); // NOI18N
        } finally {
            lock.releaseLock();

            if (writer != null) {
                writer.close();
            }
        }

        return htmlFile;
    }
}
