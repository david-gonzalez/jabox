/*
 * Jabox Open Source Version
 * Copyright (C) 2009-2010 Dimitris Kapanidis                                                                                                                          
 * 
 * This file is part of Jabox
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see http://www.gnu.org/licenses/.
 */
package org.jabox.scm.esvn;

import org.jabox.model.DeployerConfig;
import org.jabox.model.Server;
import org.jabox.scm.svn.ISVNConnectorConfig;
import org.jabox.scm.svn.SubversionRepository;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNURL;

public class ESVNConnectorConfig extends DeployerConfig implements
        ISVNConnectorConfig {
    private static final long serialVersionUID = 6542402958304063770L;

    public ESVNConnectorConfig() {
        pluginId = "plugin.scm.esvn";
    }

    public SVNURL getSvnDir() throws SVNException {
        return SVNURL
            .fromFile(SubversionRepository.getSubversionBaseDir());
    }

    /**
     * We don't need username on embedded.
     */
    public String getUsername() {
        return "";
    }

    /**
     * We don't need password on embedded.
     */
    public String getPassword() {
        return "";
    }

    @Override
    public void setServer(final Server server) {
        super.setServer(server);
        if (server != null) {
            server.setUrl(getScmUrl());
        }
    }

    public String getScmUrl() {
        try {
            return getSvnDir().toDecodedString();
        } catch (SVNException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public String getProjectScmUrl(String projectName) {
        return getScmUrl() + "/" + projectName + "/trunk/" + projectName;
    }

    @Override
    public String getScmMavenPrefix() {
        return "scm:svn:";
    }
}
