package com.audelia.backend.loginregistration.loginregistration.util.converter;

import com.audelia.backend.loginregistration.loginregistration.dto.*;
import com.audelia.backend.loginregistration.loginregistration.model.*;
import com.audelia.backend.loginregistration.loginregistration.model.Class;
import org.springframework.stereotype.Component;

@Component
public class DtoConverter {

    public SuperDTO convertToDTO(SuperEntity entity) {

        System.out.println("inside convert to dto");

        if (entity instanceof Admin) {
            Admin admin = (Admin) entity;
            return new AdminDTO(admin.getRegistrationNumber(), admin.getFullName(), admin.getGender(), admin.getPassword(), admin.getDestination(), admin.getEmail(), admin.getContactNumber(), admin.getProfile_uri());
        }else if(entity instanceof Parent){
            Parent parent = (Parent) entity;
            return new ParentDTO(parent.getRegistrationNumber(),parent.getFullName(),parent.getAddress(),parent.getGender(),parent.getEmail(),parent.getPassword(),parent.getContactNumber(),parent.getProfile_uri());
        }else if(entity instanceof Student){
            Student student = (Student) entity;
            return new StudentDTO(student.getRegistrationNumber(),(ParentDTO) convertToDTO(student.getParent()),student.getFullName(),student.getBirthday(),student.getGender(),student.getCurrentAddress(),student.getContactNumber(),student.getPassword(),student.getProfile_uri());
        }else if(entity instanceof Teacher){
            Teacher teacher = (Teacher) entity;
            return new TeacherDTO(teacher.getRegistrationNumber(),teacher.getFullName(),teacher.getGender(),teacher.getEmail(),teacher.getPassword(),teacher.getContactNumber(),teacher.getProfile_uri());
        }else if(entity instanceof Subject){
            Subject subject = (Subject) entity;
            return new SubjectDTO(subject.getsubjectId(),subject.getName());
        }else if(entity instanceof Class){
            Class aclss = (Class) entity;
            return new ClassDTO(aclss.getClassID().getGrade(),aclss.getClassID().getId(),aclss.getClassID().getYear(),aclss.getLocation(),aclss.getMedium(),aclss.getStream(),(TeacherDTO) convertToDTO(aclss.getTeacher()));
        }else if(entity instanceof ClassSubject){
            ClassSubject classSubject = (ClassSubject) entity;
            return new ClassSubjectDTO(classSubject.getId(),(ClassDTO) convertToDTO(classSubject.getaClass()),(SubjectDTO) convertToDTO(classSubject.getSubject()),(TeacherDTO) convertToDTO(classSubject.getTeacher()));
        }else if(entity instanceof LearningMaterials){
            LearningMaterials learningMaterials = (LearningMaterials) entity;
            return new LearningMaterialsDTO(learningMaterials.getId(),learningMaterials.getType(),learningMaterials.getDate(),learningMaterials.getDescription(),learningMaterials.getMaterialUri(),(ClassSubjectDTO) convertToDTO(learningMaterials.getClassSubject()));
        }else if(entity instanceof Examination){
            Examination examination = (Examination) entity;
            return new ExaminationDTO(examination.getId(),examination.getDescription(),examination.getDate(),examination.getType(), examination.getSourceUri(), examination.getDueDate(), (ClassSubjectDTO) convertToDTO(examination.getClassSubject()));
        }else if(entity instanceof Result){
            Result result = (Result) entity;
            return new ResultDTO(result.getId(),result.getMark(),(ExaminationDTO) convertToDTO(result.getExamination()),(StudentDTO) convertToDTO(result.getStudent()));
        }else if(entity instanceof TeacherNews){
            TeacherNews teacherNews = (TeacherNews) entity;
            return new TeacherNewsDTO(teacherNews.getId(),teacherNews.getDate(), teacherNews.getTitle(), teacherNews.getDescription(),teacherNews.getProfile_uri(),(AdminDTO) convertToDTO(teacherNews.getApprovedBy()),(TeacherDTO) convertToDTO(teacherNews.getTeacher()),teacherNews.getStatus());
        }else if(entity instanceof AdminNews){
            AdminNews adminNews = (AdminNews) entity;
            return new AdminNewsDTO(adminNews.getId(),adminNews.getDate(), adminNews.getTitle(), adminNews.getDescription(),adminNews.getProfile_uri(),(AdminDTO) convertToDTO(adminNews.getAdmin()));
        }else if(entity instanceof Articles){
            Articles articles = (Articles)entity;
            return new ArticlesDTO(articles.getId(),articles.getDate(),articles.getTitle(),articles.getDescription(),articles.getImageUri(),articles.getStatus(),(TeacherDTO) convertToDTO(articles.getTeacher()),(StudentDTO) convertToDTO(articles.getUploadBy()));
        }else if(entity instanceof Attendance){
            Attendance attendance = (Attendance) entity;
            return new AttendanceDTO(attendance.getPrimaryKey().getDate(),(ClassSubjectDTO)  convertToDTO(attendance.getPrimaryKey().getClassStudent()) , (TeacherDTO) convertToDTO(attendance.getTeacher()),attendance.isStatus());
        }else if(entity instanceof StudentClassSubject){
            StudentClassSubject studentClassSubject = (StudentClassSubject) entity;
            return new StudentClassSubjectDTO(studentClassSubject.getId(),(ClassSubjectDTO) convertToDTO(studentClassSubject.getClassSubject()),(StudentDTO) convertToDTO(studentClassSubject.getStudent()));
        }else if(entity instanceof ClassStudent){
            ClassStudent classStudent = (ClassStudent) entity;
            return new ClassStudentDTO(classStudent.getId(),(ClassDTO) convertToDTO(classStudent.getaClass()),(StudentDTO) convertToDTO(classStudent.getStudent()));
        }
        return null;
    }






}
