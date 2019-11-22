package com.audelia.backend.loginregistration.loginregistration.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDTO extends SuperDTO{
    private String registrationNumber;

    private ParentDTO parent;
    private String fullName;
    private Date birthday;
    private String gender;
    private String currentAddress;
    private String contactNumber;
    private String password;
    private String profile_uri;
    private List<ResultDTO> resultList = new ArrayList<>();
    private List<StudentClassSubjectDTO> studentClassSubjects = new ArrayList<>();
    private List<ClassStudentDTO> classStudents = new ArrayList<>();

    public StudentDTO() {
    }

    public StudentDTO(String registrationNumber, ParentDTO parent, String fullName, Date birthday, String gender, String currentAddress, String contactNumber, String password, String profile_uri) {
        this.registrationNumber = registrationNumber;
        this.parent = parent;
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.currentAddress = currentAddress;
        this.contactNumber = contactNumber;
        this.password = password;
        this.profile_uri = profile_uri;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public ParentDTO getParent() {
        return parent;
    }

    public void setParent(ParentDTO parent) {
        this.parent = parent;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfile_uri() {
        return profile_uri;
    }

    public void setProfile_uri(String profile_uri) {
        this.profile_uri = profile_uri;
    }

    public List<ResultDTO> getResultList() {
        return resultList;
    }

    public void setResultList(List<ResultDTO> resultList) {
        this.resultList = resultList;
    }

    public List<StudentClassSubjectDTO> getStudentClassSubjects() {
        return studentClassSubjects;
    }

    public void setStudentClassSubjects(List<StudentClassSubjectDTO> studentClassSubjects) {
        this.studentClassSubjects = studentClassSubjects;
    }

    public List<ClassStudentDTO> getClassStudents() {
        return classStudents;
    }

    public void setClassStudents(List<ClassStudentDTO> classStudents) {
        this.classStudents = classStudents;
    }
}
