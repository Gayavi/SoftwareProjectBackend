package com.audelia.backend.loginregistration.loginregistration.dto;

import java.util.ArrayList;
import java.util.List;

public class ParentDTO extends SuperDTO{

    private String registrationNumber;
    private String fullName;
    private String address;
    private String gender;
    private String email;
    private String password;
    private String contactNumber;
    private String profile_uri;
    private List<StudentDTO> student = new ArrayList<>();

    public ParentDTO() {
    }

    public ParentDTO(String registrationNumber, String fullName, String address, String gender, String email, String password, String contactNumber, String profile_uri) {
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

    public List<StudentDTO> getStudent() {
        return student;
    }

    public void setStudent(List<StudentDTO> student) {
        this.student = student;
    }
}
