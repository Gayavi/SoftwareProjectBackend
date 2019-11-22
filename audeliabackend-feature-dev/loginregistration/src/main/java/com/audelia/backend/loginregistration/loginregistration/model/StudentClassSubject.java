package com.audelia.backend.loginregistration.loginregistration.model;


import javax.persistence.*;

@Entity
@Table
public class StudentClassSubject extends SuperEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @ManyToOne
    @JoinColumn(name = "classSubject")
    private ClassSubject classSubject;

    @ManyToOne
    @JoinColumn(name = "student")
    private Student student;

    public StudentClassSubject() {
    }

    public StudentClassSubject(ClassSubject classSubject, Student student) {
        this.classSubject = classSubject;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClassSubject getClassSubject() {
        return classSubject;
    }

    public void setClassSubject(ClassSubject classSubject) {
        this.classSubject = classSubject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
