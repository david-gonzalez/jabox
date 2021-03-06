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
package org.jabox.model;

import java.io.Serializable;

import org.apache.wicket.persistence.domain.BaseEntity;
import org.jabox.apis.ConnectorConfig;

public abstract class DeployerConfig extends BaseEntity implements
        ConnectorConfig, Serializable {
    private static final long serialVersionUID = -1502838460606670036L;

    public String pluginId;

    public Server server;

    public String getPluginId() {
        return pluginId;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(final Server server) {
        this.server = server;
    }
}
