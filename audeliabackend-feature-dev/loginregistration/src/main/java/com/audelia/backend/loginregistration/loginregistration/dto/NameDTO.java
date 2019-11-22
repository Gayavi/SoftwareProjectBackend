package com.audelia.backend.loginregistration.loginregistration.dto;

import java.util.ArrayList;
import java.util.List;

public class NameDTO {

    private String name;
    private List<NameDTO> children = new ArrayList<>();


    public NameDTO() {
    }

    public NameDTO(String name) {
        this.name = name;
    }

    public NameDTO(String name, List<NameDTO> children) {
        this.name = name;
        this.children = children;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NameDTO> getChildren() {
        return children;
    }

    public void setChildren(List<NameDTO> children) {
        this.children = children;
    }
}
