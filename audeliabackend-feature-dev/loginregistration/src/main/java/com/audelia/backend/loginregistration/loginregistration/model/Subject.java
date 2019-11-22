package com.audelia.backend.loginregistration.loginregistration.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SUBJECT")
public class Subject extends SuperEntity{

    @Id
    @Column(name = "SUBJECT_ID")
    private String subjectId;
    @Column(name = "NAME",nullable = false)
    private String name;

    public Subject() {
    }

    public Subject(String subjectId, String name) {
        this.subjectId = subjectId;
        this.name = name;
    }


    public String getsubjectId() {
        return subjectId;
    }

    public void setsubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
