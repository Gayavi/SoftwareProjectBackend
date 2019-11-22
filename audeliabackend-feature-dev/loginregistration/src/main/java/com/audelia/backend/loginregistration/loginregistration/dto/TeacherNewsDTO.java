package com.audelia.backend.loginregistration.loginregistration.dto;

public class TeacherNewsDTO extends SuperDTO{
    private int id;
    private String date;
    private String title;
    private String description;
    private String profile_uri;
    private AdminDTO approvedBy;
    private TeacherDTO teacher;
    private String state;

    public TeacherNewsDTO() {
    }

    public TeacherNewsDTO(int id, String date, String title, String description, String profile_uri, AdminDTO approvedBy, TeacherDTO teacher, String state) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.description = description;
        this.profile_uri = profile_uri;
        this.approvedBy = approvedBy;
        this.teacher = teacher;
        this.state= state;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfile_uri() {
        return profile_uri;
    }

    public void setProfile_uri(String profile_uri) {
        this.profile_uri = profile_uri;
    }

    public AdminDTO getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(AdminDTO approvedBy) {
        this.approvedBy = approvedBy;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
