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
package org.netbeans.modules.debugger.ui.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import org.netbeans.api.editor.EditorActionRegistration;
import org.netbeans.spi.debugger.ui.Constants;
import org.openide.util.NbBundle.Messages;

@EditorActionRegistration(name="toggle-inline-values",
                          menuPath="View",
                          menuPosition=899,
                          preferencesKey=Constants.KEY_INLINE_VALUES,
                          preferencesDefault=Constants.DEF_INLINE_VALUES)
@Messages({
    "toggle-inline-values=Show Inline Values",
    "toggle-inline-values_menu_text=Show Inline V&alues"
})
public class ShowInlineValuesAction extends AbstractAction {
    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
