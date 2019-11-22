package com.audelia.backend.loginregistration.loginregistration.model;


import javax.persistence.*;

@Entity
@Table(name = "RESULT")
public class Result extends SuperEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "MARK")
    private int mark;

    @ManyToOne
    @JoinColumn(name = "examination")
    private Examination examination;

    @ManyToOne
    @JoinColumn(name = "student")
    private Student student;

    public Result() {
    }

    public Result(int mark, Examination examination, Student student) {
        this.mark = mark;
        this.examination = examination;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Examination getExamination() {
        return examination;
    }

    public void setExamination(Examination examination) {
        this.examination = examination;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
