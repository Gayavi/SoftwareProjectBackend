package com.audelia.backend.loginregistration.loginregistration.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TEACHER")
public class Teacher extends SuperEntity{

    @Id
    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;
    @Column(name = "FULL_NAME",nullable = false)
    private String fullName;
    @Column(name = "GENDER",nullable = false)
    private String gender;
    @Column(name = "EMAIL",nullable = false)
    private String email;
    @Column(name = "PASSWORD",nullable = false)
    private String password;
    @Column(name = "CONTACT_NUMBER",nullable = false)
    private String contactNumber;
    @Column(name = "PROFILE_URL")
    private String profile_uri;

    @OneToMany(mappedBy = "teacher")
    private List<Class> classList = new ArrayList<>();

    @OneToMany(mappedBy = "teacher")
    private List<Attendance> attendanceList = new ArrayList<>();

    @OneToMany(mappedBy = "teacher")
    private List<Articles> articles = new ArrayList<>();

    @OneToMany(mappedBy = "teacher")
    private List<ClassSubject> classSubjectList = new ArrayList<>();

    public Teacher() {
    }

    public Teacher(String registrationNumber, String fullName, String gender, String email, String password, String contactNumber) {
        this.registrationNumber = registrationNumber;
        this.fullName = fullName;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
    }

    public Teacher(String registrationNumber, String fullName, String gender, String email, String password, String contactNumber, String profile_uri) {
        this.registrationNumber = registrationNumber;
        this.fullName = fullName;
        this.gender = gender;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Class> getClassList() {
        return classList;
    }


    public List<Attendance> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<Attendance> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    public void setClassList(List<Class> classList) {
        this.classList = classList;
    }

    public List<ClassSubject> getClassSubjectList() {
        return classSubjectList;
    }

    public void setClassSubjectList(List<ClassSubject> classSubjectList) {
        this.classSubjectList = classSubjectList;
    }
}
