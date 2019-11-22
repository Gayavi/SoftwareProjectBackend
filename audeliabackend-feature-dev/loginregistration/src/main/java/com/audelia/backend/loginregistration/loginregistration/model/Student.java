package com.audelia.backend.loginregistration.loginregistration.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "STUDENT")
public class Student extends SuperEntity{

    @Id
    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;

    @ManyToOne
    @JoinColumn(name = "parent")
    private Parent parent;

    @Column(name = "FULL_NAME",nullable = false)
    private String fullName;
    @Column(name = "BIRTHDAY",nullable = false)
    private Date birthday;
    @Column(name = "GENDER",nullable = false)
    private String gender;
    @Column(name = "CURRENT_ADDRESS",nullable = false)
    private String currentAddress;
    @Column(name = "CONTACT_NUMBER",nullable = false)
    private String contactNumber;
    @Column(name = "PASSWORD",nullable = false)
    private String password;
    @Column(name = "PROFILE_UTI")
    private String profile_uri;



    @OneToMany(mappedBy = "student")
    private List<Result> resultList = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<StudentClassSubject> studentClassSubjects = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<ClassStudent> classStudents = new ArrayList<>();

    public Student() {
    }

    public Student(String registrationNumber, Parent parent, String fullName, Date birthday, String gender, String currentAddress, String contactNumber, String password, String profile_uri) {
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

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
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

    public List<Result> getResultList() {
        return resultList;
    }

    public void setResultList(List<Result> resultList) {
        this.resultList = resultList;
    }

    public List<StudentClassSubject> getStudentClassSubjects() {
        return studentClassSubjects;
    }

    public void setStudentClassSubjects(List<StudentClassSubject> studentClassSubjects) {
        this.studentClassSubjects = studentClassSubjects;
    }

    public List<ClassStudent> getClassStudents() {
        return classStudents;
    }

    public void setClassStudents(List<ClassStudent> classStudents) {
        this.classStudents = classStudents;
    }
}
