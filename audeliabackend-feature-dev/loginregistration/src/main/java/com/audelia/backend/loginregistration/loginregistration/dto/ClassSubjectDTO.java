package com.audelia.backend.loginregistration.loginregistration.dto;

import java.util.ArrayList;
import java.util.List;

public class ClassSubjectDTO extends SuperDTO{
    private int id;
    private ClassDTO aClass;
    private SubjectDTO subject;
    private TeacherDTO teacher;
    private List<LearningMaterialsDTO> learningMaterialsList = new ArrayList<>();
    private List<ExaminationDTO> examinationList = new ArrayList<>();
    private List<StudentClassSubjectDTO> studentClassSubjects = new ArrayList<>();

    public ClassSubjectDTO() {
    }

    public ClassSubjectDTO(int id, ClassDTO aClass, SubjectDTO subject, TeacherDTO teacher) {
        this.id = id;
        this.aClass = aClass;
        this.subject = subject;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClassDTO getaClass() {
        return aClass;
    }

    public void setaClass(ClassDTO aClass) {
        this.aClass = aClass;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public List<LearningMaterialsDTO> getLearningMaterialsList() {
        return learningMaterialsList;
    }

    public void setLearningMaterialsList(List<LearningMaterialsDTO> learningMaterialsList) {
        this.learningMaterialsList = learningMaterialsList;
    }

    public List<ExaminationDTO> getExaminationList() {
        return examinationList;
    }

    public void setExaminationList(List<ExaminationDTO> examinationList) {
        this.examinationList = examinationList;
    }

    public List<StudentClassSubjectDTO> getStudentClassSubjects() {
        return studentClassSubjects;
    }

    public void setStudentClassSubjects(List<StudentClassSubjectDTO> studentClassSubjects) {
        this.studentClassSubjects = studentClassSubjects;
    }
}
