package com.example.demo.entity;

import java.util.Map;

public class MyGetJSONObject {
    private String method="GET";
    private String note="在每个service中,key代表访问路径,value为描述信息";
    private Map<String,String> services;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Map<String, String> getService() {
        return services;
    }

    public void setService(Map<String, String> service) {
        this.services = service;
    }

    public MyGetJSONObject(Map<String, String> service) {
        this.services = service;
    }

    @Override
    public String toString() {
        return "MyGetJSONObject{" +
                "method='" + method + '\'' +
                ", note='" + note + '\'' +
                ", service=" + services +
                '}';
    }
}
