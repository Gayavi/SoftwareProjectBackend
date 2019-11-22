package com.audelia.backend.loginregistration.loginregistration.model;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLASS_SUBJECT")
@DynamicUpdate
public class ClassSubject extends SuperEntity {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "classID.grade", insertable = true, updatable = true),
            @JoinColumn(name = "classID.id", insertable = true, updatable = true),
            @JoinColumn(name = "classID.year", insertable = true, updatable = true)
    })
    private Class aClass;

    @ManyToOne
    @JoinColumn(name = "subject")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher")
    private Teacher teacher;

    @OneToMany(mappedBy = "classSubject")
    private List<LearningMaterials> learningMaterialsList = new ArrayList<>();

    @OneToMany(mappedBy = "classSubject")
    private List<Examination> examinationList = new ArrayList<>();

    @OneToMany(mappedBy = "classSubject")
    private List<StudentClassSubject> studentClassSubjects = new ArrayList<>();


    public ClassSubject() {
    }

    public ClassSubject( Class aClass, Subject subject, Teacher teacher) {
        this.aClass = aClass;
        this.subject = subject;
        this.teacher = teacher;
    }


    public List<LearningMaterials> getLearningMaterialsList() {
        return learningMaterialsList;
    }

    public void setLearningMaterialsList(List<LearningMaterials> learningMaterialsList) {
        this.learningMaterialsList = learningMaterialsList;
    }

    public List<Examination> getExaminationList() {
        return examinationList;
    }

    public void setExaminationList(List<Examination> examinationList) {
        this.examinationList = examinationList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<StudentClassSubject> getStudentClassSubjects() {
        return studentClassSubjects;
    }

    public void setStudentClassSubjects(List<StudentClassSubject> studentClassSubjects) {
        this.studentClassSubjects = studentClassSubjects;
    }
}
