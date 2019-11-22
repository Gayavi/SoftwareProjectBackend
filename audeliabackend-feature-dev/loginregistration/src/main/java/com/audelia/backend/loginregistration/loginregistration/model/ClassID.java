package com.audelia.backend.loginregistration.loginregistration.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;


@Embeddable
public class ClassID  implements Serializable {

    private String grade;
    private String id;
    private String year;

    public ClassID() {
    }

    public ClassID(String grade, String id, String year) {
        this.grade = grade;
        this.id = id;
        this.year = year;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassID)) return false;
        ClassID classID = (ClassID) o;
        return getGrade().equals(classID.getGrade()) &&
                getId().equals(classID.getId()) &&
                getYear().equals(classID.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGrade(), getId(), getYear());
    }
}
