package com.audelia.backend.loginregistration.loginregistration.dto;

public class LearningMaterialsDTO extends SuperDTO{
    private int id;
    private String type;
    private String date;
    private String description;
    private String materialUri;
    private ClassSubjectDTO classSubject;

    public LearningMaterialsDTO() {
    }

    public LearningMaterialsDTO(int id, String type, String date, String description, String materialUri, ClassSubjectDTO classSubject) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.description = description;
        this.materialUri = materialUri;
        this.classSubject = classSubject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMaterialUri() {
        return materialUri;
    }

    public void setMaterialUri(String materialUri) {
        this.materialUri = materialUri;
    }

    public ClassSubjectDTO getClassSubject() {
        return classSubject;
    }

    public void setClassSubject(ClassSubjectDTO classSubject) {
        this.classSubject = classSubject;
    }
}
