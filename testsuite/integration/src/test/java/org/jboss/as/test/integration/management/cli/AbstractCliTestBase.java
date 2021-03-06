/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.as.test.integration.management.cli;

import java.net.MalformedURLException;
import java.net.URL;
import org.jboss.as.test.integration.management.util.CLIWrapper;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 *
 * @author Dominik Pospisil <dpospisi@redhat.com>
 */
public class AbstractCliTestBase {
    
    public final static long WAIT_TIMEOUT = 1000;
    protected static CLIWrapper cli;    
    
    @BeforeClass
    public static void before() throws Exception {
        if (cli == null) cli = new CLIWrapper(true);
    }
    
    @AfterClass
    public static void after() throws Exception {
        try {        
            cli.quit();
        } finally {
            cli = null;
        }
    }    

    protected final String getBaseURL(URL url) throws MalformedURLException {
        return new URL(url.getProtocol(), url.getHost(), url.getPort(), "/").toString();
    }
    
}
