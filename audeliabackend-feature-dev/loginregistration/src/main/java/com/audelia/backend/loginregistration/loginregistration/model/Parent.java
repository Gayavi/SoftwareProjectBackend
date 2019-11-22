package com.audelia.backend.loginregistration.loginregistration.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PARENT")
public class Parent extends SuperEntity  {

    @Id
    @Column(name = "REGISTRATION_NUMBER",nullable = false)
    private String registrationNumber;
    @Column(name = "FULL_NAME",nullable = false)
    private String fullName;
    @Column(name = "ADDRESS",nullable = false)
    private String address;
    @Column(name = "GENDER",nullable = false)
    private String gender;
    @Column(name = "EMAIl",nullable = false)
    private String email;
    @Column(name = "PASSWORD",nullable = false)
    private String password;
    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;
    @Column(name = "PROFILE_URI")
    private String profile_uri;

    @OneToMany(mappedBy = "parent")
    private List<Student> student = new ArrayList<>();

    public Parent() {
    }

    public Parent(String registrationNumber,  String fullName, String address, String gender, String email, String password, String contactNumber) {
        this.registrationNumber = registrationNumber;
        this.fullName = fullName;
        this.address = address;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
    }

    public Parent(String registrationNumber, String fullName, String address, String gender, String email, String password, String contactNumber, String profile_uri) {
        this.registrationNumber = registrationNumber;
        this.fullName = fullName;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
