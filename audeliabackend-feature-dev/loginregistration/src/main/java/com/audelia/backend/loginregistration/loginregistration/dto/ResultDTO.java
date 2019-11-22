package com.audelia.backend.loginregistration.loginregistration.dto;

public class ResultDTO extends SuperDTO{

    private int id;
    private int mark;
    private ExaminationDTO examination;
    private StudentDTO student;

    public ResultDTO() {

    }

    public ResultDTO(int id, int mark, ExaminationDTO examination, StudentDTO student) {
        this.id = id;
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

    public ExaminationDTO getExamination() {
        return examination;
    }

    public void setExamination(ExaminationDTO examination) {
        this.examination = examination;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }
}
