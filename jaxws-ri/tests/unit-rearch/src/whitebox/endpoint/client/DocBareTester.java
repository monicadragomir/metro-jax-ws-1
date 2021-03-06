/*
 * Copyright (c) 2013, 2018 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package whitebox.endpoint.client;

import java.io.StringReader;
import java.net.URL;
 
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;

import javax.xml.stream.*;
import java.io.*;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import junit.framework.TestCase;

/**
 * @author Jitendra Kotamraju
 */

public class DocBareTester extends TestCase
{
    private static final String NS = "http://echo.org/";

    public void testBare() throws Exception {
        int port = Util.getFreePort();
        String address = "http://localhost:"+port+"/bare";
        Endpoint endpoint = Endpoint.create(new BareService());
        endpoint.publish(address);
        endpoint.stop();
    }

    @WebService
    @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    public class BareService {
     
	public String foo(int i) {
	    return "foo";
	}
     
	public String bar(int i) {
	    return "bar";
	}
     
    }
}
