package com.audelia.backend.loginregistration.loginregistration.dto;

public class ChildrenDTO {

    private String name;
    private ChildrenDTO children;

    public ChildrenDTO() {
    }

    public ChildrenDTO(String name) {
        this.name = name;
    }

    public ChildrenDTO(String name, ChildrenDTO children) {
        this.name = name;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChildrenDTO getChildren() {
        return children;
    }

    public void setChildren(ChildrenDTO children) {
        this.children = children;
    }
}
