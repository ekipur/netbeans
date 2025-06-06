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
package org.netbeans.modules.glassfish.tooling.admin;

import org.netbeans.modules.glassfish.tooling.data.GlassFishServer;

/**
 *
 * @author Tomas Kraus, Peter Benedikovic
 */
public class RunnerRestStopDAS extends RunnerRest {

    // Constructors                                                           //
    /**
     * Constructs an instance of administration command executor using
     * REST interface.
     * <p/>
     * @param server  GlassFish server entity object.
     * @param command GlassFish server administration command entity.
     */
    public RunnerRestStopDAS(final GlassFishServer server,
            final Command command) {
        super(server, command);
    }

//    @Override
//    protected String constructCommandUrl() throws CommandException {
//        String protocol = "http";
//        URI uri;
//        try {
//            uri = new URI(protocol, null, server.getHost(), server.getAdminPort(), path + "stop", query, null);
//        } catch (URISyntaxException use) {
//            throw new CommandException(CommandException.RUNNER_HTTP_URL, use);
//        }
//        return uri.toASCIIString();
//    }
//
//    @Override
//    protected String getRequestMethod() {
//        return "POST";
//    }
}
