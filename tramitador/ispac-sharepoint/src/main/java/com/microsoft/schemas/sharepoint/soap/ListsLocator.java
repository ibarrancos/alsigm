/**
 * ListsLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.microsoft.schemas.sharepoint.soap;

import ieci.tdw.ispac.ispaclib.utils.StringUtils;

public class ListsLocator extends org.apache.axis.client.Service implements com.microsoft.schemas.sharepoint.soap.Lists {

	private String user;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}    

    private void setSecurityData(ListsSoapStub _stub) {
        //A�adimos los datos de seguridad y timeout.
        if (StringUtils.isNotEmpty(user)){
        	_stub.setUsername(user);
        }
        if (StringUtils.isNotEmpty(password)){
        	_stub.setPassword(password);
        }
	}	
	
    public ListsLocator() {
    }


    public ListsLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ListsLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ListsSoap12
    private java.lang.String ListsSoap12_address = "http://istgodesa01/_vti_bin/lists.asmx";

    public java.lang.String getListsSoap12Address() {
        return ListsSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ListsSoap12WSDDServiceName = "ListsSoap12";

    public java.lang.String getListsSoap12WSDDServiceName() {
        return ListsSoap12WSDDServiceName;
    }

    public void setListsSoap12WSDDServiceName(java.lang.String name) {
        ListsSoap12WSDDServiceName = name;
    }

    public com.microsoft.schemas.sharepoint.soap.ListsSoap getListsSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ListsSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getListsSoap12(endpoint);
    }

    public com.microsoft.schemas.sharepoint.soap.ListsSoap getListsSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.microsoft.schemas.sharepoint.soap.ListsSoap12Stub _stub = new com.microsoft.schemas.sharepoint.soap.ListsSoap12Stub(portAddress, this);
            _stub.setPortName(getListsSoap12WSDDServiceName());

           
            
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setListsSoap12EndpointAddress(java.lang.String address) {
        ListsSoap12_address = address;
    }


    // Use to get a proxy class for ListsSoap
    private java.lang.String ListsSoap_address = "http://istgodesa01/_vti_bin/lists.asmx";

    public java.lang.String getListsSoapAddress() {
        return ListsSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ListsSoapWSDDServiceName = "ListsSoap";

    public java.lang.String getListsSoapWSDDServiceName() {
        return ListsSoapWSDDServiceName;
    }

    public void setListsSoapWSDDServiceName(java.lang.String name) {
        ListsSoapWSDDServiceName = name;
    }

    public com.microsoft.schemas.sharepoint.soap.ListsSoap getListsSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ListsSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getListsSoap(endpoint);
    }

    public com.microsoft.schemas.sharepoint.soap.ListsSoap getListsSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.microsoft.schemas.sharepoint.soap.ListsSoapStub _stub = new com.microsoft.schemas.sharepoint.soap.ListsSoapStub(portAddress, this);
            _stub.setPortName(getListsSoapWSDDServiceName());
            
            setSecurityData(_stub);
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setListsSoapEndpointAddress(java.lang.String address) {
        ListsSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.microsoft.schemas.sharepoint.soap.ListsSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.microsoft.schemas.sharepoint.soap.ListsSoap12Stub _stub = new com.microsoft.schemas.sharepoint.soap.ListsSoap12Stub(new java.net.URL(ListsSoap12_address), this);
                _stub.setPortName(getListsSoap12WSDDServiceName());
                return _stub;
            }
            if (com.microsoft.schemas.sharepoint.soap.ListsSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                com.microsoft.schemas.sharepoint.soap.ListsSoapStub _stub = new com.microsoft.schemas.sharepoint.soap.ListsSoapStub(new java.net.URL(ListsSoap_address), this);
                _stub.setPortName(getListsSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ListsSoap12".equals(inputPortName)) {
            return getListsSoap12();
        }
        else if ("ListsSoap".equals(inputPortName)) {
            return getListsSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://schemas.microsoft.com/sharepoint/soap/", "Lists");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://schemas.microsoft.com/sharepoint/soap/", "ListsSoap12"));
            ports.add(new javax.xml.namespace.QName("http://schemas.microsoft.com/sharepoint/soap/", "ListsSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ListsSoap12".equals(portName)) {
            setListsSoap12EndpointAddress(address);
        }
        else 
if ("ListsSoap".equals(portName)) {
            setListsSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
