package com.example.demo.entity;

import java.util.Map;

public class PostService {
    private String url;
    private String note;
    private Map<String,String> params;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNode() {
        return note;
    }

    public void setNode(String node) {
        this.note = node;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public PostService(String url, String node, Map<String, String> params) {
        this.url = url;
        this.note = node;
        this.params = params;
    }

    @Override
    public String toString() {
        return "PostService{" +
                "url='" + url + '\'' +
                ", note='" + note + '\'' +
                ", params=" + params +
                '}';
    }
}
