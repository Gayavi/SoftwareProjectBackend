package com.audelia.backend.loginregistration.loginregistration.util.converter;

import com.audelia.backend.loginregistration.loginregistration.dto.*;
import com.audelia.backend.loginregistration.loginregistration.model.*;
import com.audelia.backend.loginregistration.loginregistration.model.Class;
import org.springframework.stereotype.Component;

@Component
public class EntityConverter {

     public SuperEntity convertToEntity(SuperDTO dto){
         System.out.println("inside convert to entity");

         if (dto instanceof AdminDTO) {
             AdminDTO adminDTO = (AdminDTO) dto;
             return new Admin(adminDTO.getRegistrationNumber(), adminDTO.getFullName(), adminDTO.getGender(), adminDTO.getPassword(), adminDTO.getDestination(), adminDTO.getEmail(), adminDTO.getContactNumber(), adminDTO.getProfile_uri());
         }else if(dto instanceof ParentDTO){
             ParentDTO parentDTO = (ParentDTO) dto;
             return new Parent(parentDTO.getRegistrationNumber(),parentDTO.getFullName(),parentDTO.getAddress(),parentDTO.getGender(),parentDTO.getEmail(),parentDTO.getPassword(),parentDTO.getContactNumber(),parentDTO.getProfile_uri());
         }else if(dto instanceof StudentDTO){
             StudentDTO studentDTO = (StudentDTO) dto;
             return new Student(studentDTO.getRegistrationNumber(),(Parent) convertToEntity(studentDTO.getParent()),studentDTO.getFullName(),studentDTO.getBirthday(),studentDTO.getGender(),studentDTO.getCurrentAddress(),studentDTO.getContactNumber(),studentDTO.getPassword(),studentDTO.getProfile_uri());
         }else if(dto instanceof TeacherDTO){
             TeacherDTO teacherDTO = (TeacherDTO) dto;
             return new Teacher(teacherDTO.getRegistrationNumber(),teacherDTO.getFullName(),teacherDTO.getGender(),teacherDTO.getEmail(),teacherDTO.getPassword(),teacherDTO.getContactNumber(),teacherDTO.getProfile_uri());
         }else if(dto instanceof SubjectDTO){
             SubjectDTO subjectDTO = (SubjectDTO) dto;
             return new Subject(subjectDTO.getSubjectId(),subjectDTO.getName());
         }else if(dto instanceof ClassDTO){
             ClassDTO classDTO = (ClassDTO) dto;
             return new Class(new ClassID(classDTO.getGrade(),classDTO.getId(),classDTO.getYear()),classDTO.getLocation(),classDTO.getMedium(),classDTO.getStream(),(Teacher) convertToEntity(classDTO.getTeacher()));
         }else if(dto instanceof ClassSubjectDTO){
             ClassSubjectDTO classSubjectDTO = (ClassSubjectDTO) dto;
             return new ClassSubject((Class) convertToEntity(classSubjectDTO.getaClass()),(Subject) convertToEntity(classSubjectDTO.getSubject()),(Teacher) convertToEntity(classSubjectDTO.getTeacher()));
         }else if(dto instanceof LearningMaterialsDTO){
             LearningMaterialsDTO learningMaterialsDTO = (LearningMaterialsDTO) dto;
             return new LearningMaterials(learningMaterialsDTO.getType(),learningMaterialsDTO.getDate(),learningMaterialsDTO.getDescription(),learningMaterialsDTO.getMaterialUri(),(ClassSubject) convertToEntity(learningMaterialsDTO.getClassSubject()));
         }else if(dto instanceof ExaminationDTO){
             ExaminationDTO examinationDTO = (ExaminationDTO) dto;
             return new Examination(examinationDTO.getDescription(),examinationDTO.getDate(),examinationDTO.getType(), examinationDTO.getSourceUri() , examinationDTO.getDueDate(), (ClassSubject) convertToEntity(examinationDTO.getClassSubject()));
         }else if(dto instanceof ResultDTO){
             ResultDTO resultDTO = (ResultDTO) dto;
             return new Result(resultDTO.getMark(),(Examination) convertToEntity(resultDTO.getExamination()),(Student) convertToEntity(resultDTO.getStudent()));
         }else if(dto instanceof TeacherNewsDTO){
             TeacherNewsDTO teacherNewsDTO = (TeacherNewsDTO) dto;
             return new TeacherNews(teacherNewsDTO.getDate(), teacherNewsDTO.getTitle(), teacherNewsDTO.getDescription(),teacherNewsDTO.getProfile_uri(),(Admin) convertToEntity(teacherNewsDTO.getApprovedBy()),(Teacher) convertToEntity(teacherNewsDTO.getTeacher()),teacherNewsDTO.getState());
         }else if(dto instanceof AdminNewsDTO){
             AdminNewsDTO adminNewsDTO = (AdminNewsDTO) dto;
             return new AdminNews(adminNewsDTO.getDate(), adminNewsDTO.getTitle(), adminNewsDTO.getDescription(),adminNewsDTO.getProfile_uri(),(Admin) convertToEntity(adminNewsDTO.getAdminDTO()));
         }else if(dto instanceof ArticlesDTO){
             ArticlesDTO articlesDTO = (ArticlesDTO) dto;
             return new Articles(articlesDTO.getDate(),articlesDTO.getTitle(),articlesDTO.getDescription(),articlesDTO.getImageUri(),articlesDTO.getStatus(),(Teacher) convertToEntity(articlesDTO.getTeacher()),(Student) convertToEntity(articlesDTO.getUploadBy()));
         }else if(dto instanceof AttendanceDTO){
             AttendanceDTO attendanceDTO = (AttendanceDTO) dto;
             return new Attendance(new AttendanceID(attendanceDTO.getDate(),(ClassStudent) convertToEntity(attendanceDTO.getClassSubjectDTO())),(Teacher) convertToEntity(attendanceDTO.getTeacher()),attendanceDTO.isStatus());
         }else if(dto instanceof StudentClassSubjectDTO){
             StudentClassSubjectDTO studentClassSubjectDTO = (StudentClassSubjectDTO) dto;
             return new StudentClassSubject((ClassSubject) convertToEntity(studentClassSubjectDTO.getClassSubject()),(Student) convertToEntity(studentClassSubjectDTO.getStudent()));
         }else if(dto instanceof ClassStudentDTO){
             ClassStudentDTO classStudentDTO = (ClassStudentDTO) dto;
             return new ClassStudent((Class) convertToEntity(classStudentDTO.getaClass()), (Student) convertToEntity(classStudentDTO.getStudent()));
         }
         return null;
     }
}
