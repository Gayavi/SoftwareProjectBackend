package com.audelia.backend.loginregistration.loginregistration.model;

import javax.persistence.*;

@Entity
@Table(name = "CLASS")
public class Class extends SuperEntity{

    @EmbeddedId
    private ClassID classID;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "MEDIUM")
    private String medium;
    @Column(name = "STREAM")
    private String stream;


    @ManyToOne
    @JoinColumn(name = "teacher")
    private Teacher teacher;

    public Class() {
    }

    public Class(ClassID classID, String location, String medium, String stream, Teacher teacher) {
        this.classID = classID;
        this.location = location;
        this.medium = medium;
        this.stream = stream;
        this.teacher = teacher;
    }

    public ClassID getClassID() {
        return classID;
    }

    public void setClassID(ClassID classID) {
        this.classID = classID;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
