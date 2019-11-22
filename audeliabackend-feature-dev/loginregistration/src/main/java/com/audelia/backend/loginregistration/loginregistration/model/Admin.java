package com.audelia.backend.loginregistration.loginregistration.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ADMIN")
public class Admin extends SuperEntity{

    @Id
    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;
    @Column(name = "FULL_NAME",nullable = false)
    private String fullName;
    @Column(name = "GENDER",nullable = false)
    private String gender;
    @Column(name = "PASSWORD",nullable = false)
    private String password;
    @Column(name = "DESTINATION",nullable = false)
    private String destination;
    @Column(name = "EMAIL",nullable = false)
    private String email;
    @Column(name = "CONTACT_NUMBER",nullable = false)
    private String contactNumber;
    @Column(name = "PROFILE_URI")
    private String profile_uri;

    @OneToMany(mappedBy = "approvedBy")
    private List<TeacherNews> teacherNewsList = new ArrayList<>();

    @OneToMany(mappedBy = "admin")
    private List<AdminNews> adminNewsList = new ArrayList<>();

    public Admin() {
    }

    public Admin(String registrationNumber, String fullName, String gender, String password, String destination, String email, String contactNumber) {
        this.registrationNumber = registrationNumber;
        this.fullName = fullName;
        this.gender = gender;
        this.password = password;
        this.destination = destination;
        this.email = email;
        this.contactNumber = contactNumber;
    }

    public Admin(String registrationNumber, String fullName, String gender, String password, String destination, String email, String contactNumber, String profile_uri) {
        this.registrationNumber = registrationNumber;
        this.fullName = fullName;
        this.gender = gender;
        this.password = password;
        this.destination = destination;
        this.email = email;
        this.contactNumber = contactNumber;
        this.profile_uri = profile_uri;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getProfile_uri() {
        return profile_uri;
    }

    public void setProfile_uri(String profile_uri) {
        this.profile_uri = profile_uri;
    }

    public List<TeacherNews> getTeacherNewsList() {
        return teacherNewsList;
    }

    public void setTeacherNewsList(List<TeacherNews> teacherNewsList) {
        this.teacherNewsList = teacherNewsList;
    }

    public List<AdminNews> getAdminNewsList() {
        return adminNewsList;
    }

    public void setAdminNewsList(List<AdminNews> adminNewsList) {
        this.adminNewsList = adminNewsList;
    }
}
