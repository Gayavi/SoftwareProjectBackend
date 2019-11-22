package com.audelia.backend.loginregistration.loginregistration.dto;

public class ArticlesDTO extends SuperDTO{
    private int id;
    private String date;
    private String title;
    private String description;
    private String imageUri;
    private String status;
    private TeacherDTO teacher;
    private StudentDTO uploadBy;

    public ArticlesDTO() {
    }

    public ArticlesDTO(int id, String date, String title, String description, String imageUri, String status, TeacherDTO teacher, StudentDTO uploadBy) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
        this.imageUri = imageUri;
        this.status = status;
        this.teacher = teacher;
        this.uploadBy = uploadBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public StudentDTO getUploadBy() {
        return uploadBy;
    }

    public void setUploadBy(StudentDTO uploadBy) {
        this.uploadBy = uploadBy;
    }
}
