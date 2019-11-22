package com.audelia.backend.loginregistration.loginregistration.dto;

public class ClassStudentDTO extends SuperDTO {
    private int id;
    private ClassDTO aClass;
    private StudentDTO student;

    public ClassStudentDTO() {
    }

    public ClassStudentDTO(int id, ClassDTO aClass, StudentDTO student) {
        this.id = id;
        this.aClass = aClass;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClassDTO getaClass() {
        return aClass;
    }

    public void setaClass(ClassDTO aClass) {
        this.aClass = aClass;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }
}
