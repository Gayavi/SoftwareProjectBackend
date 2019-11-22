package com.audelia.backend.loginregistration.loginregistration.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;


@Entity
@Table(name = "ATTENDANCE")
@DynamicUpdate
public class Attendance extends SuperEntity{

    @EmbeddedId
    private AttendanceID primaryKey;

    @ManyToOne
    @JoinColumn(name = "teacher")
    private Teacher teacher;

    @Column(name = "STATUS")
    private boolean status;

    public Attendance() {
    }

    public Attendance(AttendanceID primaryKey, Teacher teacher, boolean status) {
        this.primaryKey = primaryKey;
        this.teacher = teacher;
        this.status = status;
    }

    public AttendanceID getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(AttendanceID primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
