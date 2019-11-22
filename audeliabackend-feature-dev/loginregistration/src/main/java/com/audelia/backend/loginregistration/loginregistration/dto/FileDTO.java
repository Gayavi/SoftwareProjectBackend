package com.audelia.backend.loginregistration.loginregistration.dto;

public class FileDTO extends SuperDTO{
    private String grade;
    private String id;
    private String year;
    private String subjectID;
    private String description;
    private String dueDate;

    public FileDTO() {
    }

    public FileDTO(String grade, String id, String year, String subjectID, String destription, String dueDate) {
        this.grade = grade;
        this.id = id;
        this.year = year;
        this.subjectID = subjectID;
        this.description = destription;
        this.dueDate = dueDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
