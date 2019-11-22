package com.audelia.backend.loginregistration.loginregistration.model;

import javax.persistence.*;

@Entity
@Table(name = "LEARNING_MATERIALS")
public class LearningMaterials extends SuperEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "DATE")
    private String date;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "MATERIAL_URI")
    private String materialUri;


    @ManyToOne
    @JoinColumn(name = "classSubject")
    private ClassSubject classSubject;

    public LearningMaterials() {
    }

    public LearningMaterials(String type, String date, String description, String materialUri, ClassSubject classSubject) {
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

    public ClassSubject getClassSubject() {
        return classSubject;
    }

    public void setClassSubject(ClassSubject classSubject) {
        this.classSubject = classSubject;
    }
}
