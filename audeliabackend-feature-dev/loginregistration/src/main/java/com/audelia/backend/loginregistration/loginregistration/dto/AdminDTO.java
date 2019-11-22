package com.audelia.backend.loginregistration.loginregistration.dto;

import java.util.ArrayList;
import java.util.List;

public class AdminDTO extends SuperDTO{

    private String registrationNumber;
    private String fullName;
    private String gender;
    private String password;
    private String destination;
    private String email;
    private String contactNumber;
    private String profile_uri;


    private List<TeacherNewsDTO> teacherNewsList = new ArrayList<>();


    private List<AdminNewsDTO> adminNewsList = new ArrayList<>();

    public AdminDTO() {
    }

    public AdminDTO(String registrationNumber, String fullName, String gender, String password, String destination, String email, String contactNumber, String profile_uri) {
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

    public List<TeacherNewsDTO> getTeacherNewsList() {
        return teacherNewsList;
    }

    public void setTeacherNewsList(List<TeacherNewsDTO> teacherNewsList) {
        this.teacherNewsList = teacherNewsList;
    }

    public List<AdminNewsDTO> getAdminNewsList() {
        return adminNewsList;
    }

    public void setAdminNewsList(List<AdminNewsDTO> adminNewsList) {
        this.adminNewsList = adminNewsList;
    }
}

