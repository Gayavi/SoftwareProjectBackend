package com.audelia.backend.loginregistration.loginregistration.dto;

public class ClassDTO extends SuperDTO{

    private String grade;
    private String id;
    private String year;
    private String location;
    private String medium;
    private String stream;
    private TeacherDTO teacher;

    public ClassDTO() {
    }

    public ClassDTO(String grade, String id, String year, String location, String medium, String stream, TeacherDTO teacher) {
        this.grade = grade;
        this.id = id;
        this.year = year;
        this.location = location;
        this.medium = medium;
        this.stream = stream;
        this.teacher = teacher;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }
}
