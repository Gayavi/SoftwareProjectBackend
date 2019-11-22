package com.audelia.backend.loginregistration.loginregistration.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "TEACHER_NEWS")
@DynamicUpdate
public class TeacherNews extends SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "DATE")
    private String date;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PROFILE_URI",nullable = false)
    private String profile_uri;


    @ManyToOne
    @JoinColumn(name = "approvedBy")
    private Admin approvedBy;

    @ManyToOne
    @JoinColumn(name = "teacher")
    private Teacher teacher;

    @Column(name = "status")
    private String status;


    public TeacherNews() {
    }


    public TeacherNews(String date, String title, String description, String profile_uri, Admin approvedBy, Teacher teacher, String status) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.profile_uri = profile_uri;
        this.approvedBy = approvedBy;
        this.teacher = teacher;
        this.status = status;
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

    public String getProfile_uri() {
        return profile_uri;
    }

    public void setProfile_uri(String profile_uri) {
        this.profile_uri = profile_uri;
    }

    public Admin getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Admin approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
