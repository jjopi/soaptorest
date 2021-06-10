package com.example.demo.entity;

import java.util.List;

public class WebServiceProxy {
    private String address_location;
    private List<ElementProxy> elementProxyList;
    private List<String> exposedMethodsList;
    private String targetNamespace;

    public WebServiceProxy(String address_location, List<ElementProxy> elementProxyList, List<String> exposedMethodsList, String targetNamespace) {
        this.address_location = address_location;
        this.elementProxyList = elementProxyList;
        this.exposedMethodsList = exposedMethodsList;
        this.targetNamespace = targetNamespace;
    }

    public String getAddress_location() {
        return address_location;
    }

    public void setAddress_location(String address_location) {
        this.address_location = address_location;
    }

    public List<ElementProxy> getElementProxyList() {
        return elementProxyList;
    }

    public void setElementProxyList(List<ElementProxy> elementProxyList) {
        this.elementProxyList = elementProxyList;
    }

    public List<String> getExposedMethodsList() {
        return exposedMethodsList;
    }

    public void setExposedMethodsList(List<String> exposedMethodsList) {
        this.exposedMethodsList = exposedMethodsList;
    }

    public String getTargetNamespace() {
        return targetNamespace;
    }

    public void setTargetNamespace(String targetNamespace) {
        this.targetNamespace = targetNamespace;
    }

    @Override
    public String toString() {
        return "WebServiceProxy{" +
                "address_location='" + address_location + '\'' +
                ", elementProxyList=" + elementProxyList +
                ", exposedMethodsList=" + exposedMethodsList +
                ", targetNamespace='" + targetNamespace + '\'' +
                '}';
    }
}
