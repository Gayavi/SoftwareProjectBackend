package com.audelia.backend.loginregistration.loginregistration.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "CLASS_STUDENT")
@DynamicUpdate
public class ClassStudent extends SuperEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "classID.grade", insertable = true, updatable = true),
            @JoinColumn(name = "classID.id", insertable = true, updatable = true),
            @JoinColumn(name = "classID.year", insertable = true, updatable = true)
    })
    private Class aClass;

    @ManyToOne
    @JoinColumn(name = "STUDENT")
    private Student student;

    public ClassStudent() {
    }

    public ClassStudent(Class aClass, Student student) {
        this.aClass = aClass;
        this.student = student;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
