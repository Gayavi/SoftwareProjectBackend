package com.audelia.backend.loginregistration.loginregistration.dto;

public class StudentClassSubjectDTO extends SuperDTO{

    private int id;
    private ClassSubjectDTO classSubject;
    private StudentDTO student;

    public StudentClassSubjectDTO() {
    }

    public StudentClassSubjectDTO(int id, ClassSubjectDTO classSubject, StudentDTO student) {
        this.id = id;
        this.classSubject = classSubject;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClassSubjectDTO getClassSubject() {
        return classSubject;
    }

    public void setClassSubject(ClassSubjectDTO classSubject) {
        this.classSubject = classSubject;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }
}
