package com.audelia.backend.loginregistration.loginregistration.model;

import javax.persistence.*;

@Entity
@Table(name = "ARTICLE")
public class Articles extends SuperEntity{


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DATE")
    private String date;



    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IMAGE_URI")
    private String imageUri;

    @Column(name = "STATUS")
    private String status;

    @ManyToOne
    @JoinColumn(name = "teacher")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "uploadBy")
    private Student uploadBy;

    public Articles() {
    }

    public Articles(String date, String title, String description, String imageUri, String status, Teacher teacher, Student uploadBy) {
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getUploadBy() {
        return uploadBy;
    }

    public void setUploadBy(Student uploadBy) {
        this.uploadBy = uploadBy;
    }
}
