package com.audelia.backend.loginregistration.loginregistration.dto;

import java.util.ArrayList;
import java.util.List;

public class TeacherDTO extends SuperDTO{

    private String registrationNumber;
    private String fullName;
    private String gender;
    private String email;
    private String password;
    private String contactNumber;
    private String profile_uri;
    private List<ClassDTO> classList = new ArrayList<>();
    private List<AttendanceDTO> attendanceList = new ArrayList<>();
    private List<ArticlesDTO> articles = new ArrayList<>();
    private List<ClassSubjectDTO> classSubjectList = new ArrayList<>();

    public TeacherDTO() {
    }

    public TeacherDTO(String registrationNumber, String fullName, String gender, String email, String password, String contactNumber, String profile_uri) {
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

    public List<ClassDTO> getClassList() {
        return classList;
    }

    public void setClassList(List<ClassDTO> classList) {
        this.classList = classList;
    }

    public List<AttendanceDTO> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<AttendanceDTO> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public List<ArticlesDTO> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlesDTO> articles) {
        this.articles = articles;
    }

    public List<ClassSubjectDTO> getClassSubjectList() {
        return classSubjectList;
    }

    public void setClassSubjectList(List<ClassSubjectDTO> classSubjectList) {
        this.classSubjectList = classSubjectList;
    }
}
