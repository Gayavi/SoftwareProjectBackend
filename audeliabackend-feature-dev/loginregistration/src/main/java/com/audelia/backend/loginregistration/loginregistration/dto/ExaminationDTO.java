package com.audelia.backend.loginregistration.loginregistration.dto;

import java.util.ArrayList;
import java.util.List;

public class ExaminationDTO extends SuperDTO{
    private int id;
    private String description;
    private String date;
    private String type;
    private String sourceUri;
    private String dueDate;
    private ClassSubjectDTO classSubject;
    private List<ResultDTO> resultList = new ArrayList<>();

    public ExaminationDTO() {
    }

    public ExaminationDTO(int id, String description, String date, String type, String sourceUri, String dueDate, ClassSubjectDTO classSubject) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.type = type;
        this.sourceUri = sourceUri;
        this.dueDate = dueDate;
        this.classSubject = classSubject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ClassSubjectDTO getClassSubject() {
        return classSubject;
    }

    public void setClassSubject(ClassSubjectDTO classSubject) {
        this.classSubject = classSubject;
    }

    public List<ResultDTO> getResultList() {
        return resultList;
    }

    public void setResultList(List<ResultDTO> resultList) {
        this.resultList = resultList;
    }

    public String getSourceUri() {
        return sourceUri;
    }

    public void setSourceUri(String sourceUri) {
        this.sourceUri = sourceUri;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}