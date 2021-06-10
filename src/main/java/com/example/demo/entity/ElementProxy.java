package com.example.demo.entity;

import java.util.List;

public class ElementProxy {
    private String name;
    private List<String> parameters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public void setParameters(List<String> parameters) {
        this.parameters = parameters;
    }

    public ElementProxy(String name, List<String> parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "ElementProxy{" +
                "name='" + name + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
