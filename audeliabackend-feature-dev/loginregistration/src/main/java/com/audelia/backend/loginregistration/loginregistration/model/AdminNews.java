package com.audelia.backend.loginregistration.loginregistration.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "NEWS")
@DynamicUpdate
public class AdminNews extends SuperEntity{

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
    @JoinColumn(name = "admin")
    private Admin admin;


    public AdminNews() {
    }

    public AdminNews(String date, String title, String description, String profile_uri, Admin admin) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.profile_uri = profile_uri;
        this.admin = admin;


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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public String getProfile_uri() {
        return profile_uri;
    }

    public void setProfile_uri(String profile_uri) {
        this.profile_uri = profile_uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
