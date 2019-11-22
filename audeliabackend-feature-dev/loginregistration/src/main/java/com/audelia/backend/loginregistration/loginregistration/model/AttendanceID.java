package com.audelia.backend.loginregistration.loginregistration.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AttendanceID implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "DATE")
    private String date;

    @ManyToOne
    private ClassStudent classStudent;

    public AttendanceID() {
    }

    public AttendanceID(String date, ClassStudent classStudent) {
        this.date = date;
        this.classStudent = classStudent;
    }


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ClassStudent getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(ClassStudent classStudent) {
        this.classStudent = classStudent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AttendanceID)) return false;
        AttendanceID that = (AttendanceID) o;
        return getDate().equals(that.getDate()) &&
                getClassStudent().equals(that.getClassStudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getClassStudent());
    }
}
