package com.example.demo.entity;

public class WebApiToSql {
    private String url;
    private WebApi webApi;


    public WebApiToSql(String url, WebApi webApi) {
        this.url = url;
        this.webApi = webApi;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public WebApi getWebApi() {
        return webApi;
    }

    public void setWebApi(WebApi webApi) {
        this.webApi = webApi;
    }

    @Override
    public String toString() {
        return "WebApiToSql{" +
                "url='" + url + '\'' +
                ", webApi=" + webApi +
                '}';
    }
}
