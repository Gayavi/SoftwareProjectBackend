package com.audelia.backend.loginregistration.loginregistration.dto;

public class SubjectDTO extends SuperDTO{

    private String subjectId;
    private String name;

    public SubjectDTO() {
    }

    public SubjectDTO(String subjectId, String name) {
        this.subjectId = subjectId;
        this.name = name;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
