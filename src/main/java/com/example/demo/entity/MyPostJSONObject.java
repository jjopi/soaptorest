package com.example.demo.entity;

import java.util.List;

public class MyPostJSONObject {
    private String method="POST";
    private String note="在每个service中，url表示访问路径,note表示参数和返回值的描述信息";
    private List<PostService> services;

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

    public List<PostService> getServices() {
        return services;
    }

    public void setServices(List<PostService> services) {
        this.services = services;
    }

    public MyPostJSONObject(List<PostService> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "MyPostJSONObject{" +
                "method='" + method + '\'' +
                ", note='" + note + '\'' +
                ", services=" + services +
                '}';
    }
}
