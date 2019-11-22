package com.audelia.backend.loginregistration.loginregistration.dto;

public class AttendanceDTO extends SuperDTO{

    private String date;
    private ClassSubjectDTO classSubjectDTO;
    private TeacherDTO teacher;
    private boolean status;


    public AttendanceDTO() {
    }


    public AttendanceDTO(String date, ClassSubjectDTO classSubjectDTO, TeacherDTO teacher, boolean status) {
        this.date = date;
        this.classSubjectDTO = classSubjectDTO;
        this.teacher = teacher;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ClassSubjectDTO getClassSubjectDTO() {
        return classSubjectDTO;
    }

    public void setClassSubjectDTO(ClassSubjectDTO classSubjectDTO) {
        this.classSubjectDTO = classSubjectDTO;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
