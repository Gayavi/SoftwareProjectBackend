package com.audelia.backend.loginregistration.loginregistration.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EXAMINATION")
public class Examination extends SuperEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "DESCRIPTION")
    private String description;


    @Column(name = "DATE")
    private String date;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "SOURCE_URI")
    private String sourceUri;

    @Column(name = "DUE_DATE")
    private String dueDate;

//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumns({
//            @JoinColumn(name = "classSubjectID.subject", insertable = false, updatable = false),
//            @JoinColumn(name = "classSubjectID.aClass.grade", insertable = false, updatable = false),
//            @JoinColumn(name = "classSubjectID.aClass.id", insertable = false, updatable = false),
//            @JoinColumn(name = "classSubjectID.aClass.subject", insertable = false, updatable = false)
//    })

    @ManyToOne
    @JoinColumn(name = "classSubject")
    private ClassSubject classSubject;

    @OneToMany(mappedBy = "examination")
    private List<Result> resultList = new ArrayList<>();

    public Examination() {
    }

    public Examination(String description, String date, String type, String sourceUri, String dueDate, ClassSubject classSubject) {
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

    public ClassSubject getClassSubject() {
        return classSubject;
    }

    public void setClassSubject(ClassSubject classSubject) {
        this.classSubject = classSubject;
    }

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
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
