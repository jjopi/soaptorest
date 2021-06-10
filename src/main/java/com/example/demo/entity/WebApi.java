package com.example.demo.entity;

public class WebApi {
    private String webService_description;
    private String url;
    private String namespaceURI;
    private MyGetJSONObject getServices;
    private MyPostJSONObject postServices;

    public String getWebService_description() {
        return webService_description;
    }

    public void setWebService_description(String webService_description) {
        this.webService_description = webService_description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MyGetJSONObject getGetServices() {
        return getServices;
    }

    public void setGetServices(MyGetJSONObject getServices) {
        this.getServices = getServices;
    }

    public MyPostJSONObject getPostServices() {
        return postServices;
    }

    public void setPostServices(MyPostJSONObject postServices) {
        this.postServices = postServices;
    }

    public String getNamespaceURI() {
        return namespaceURI;
    }

    public void setNamespaceURI(String namespaceURI) {
        this.namespaceURI = namespaceURI;
    }

    public WebApi(String webService_description, String url, String namespaceURI, MyGetJSONObject getServices, MyPostJSONObject postServices) {
        this.webService_description = webService_description;
        this.url = url;
        this.namespaceURI = namespaceURI;
        this.getServices = getServices;
        this.postServices = postServices;
    }

    @Override
    public String toString() {
        return "WebApi{" +
                "webService_description='" + webService_description + '\'' +
                ", url='" + url + '\'' +
                ", namespaceURI='" + namespaceURI + '\'' +
                ", getServices=" + getServices +
                ", postServices=" + postServices +
                '}';
    }
}
