package com.audelia.backend.loginregistration.loginregistration.controller;

import com.audelia.backend.loginregistration.loginregistration.dto.*;
import com.audelia.backend.loginregistration.loginregistration.model.*;
import com.audelia.backend.loginregistration.loginregistration.model.Class;
import com.audelia.backend.loginregistration.loginregistration.repository.*;
import com.audelia.backend.loginregistration.loginregistration.util.converter.DtoConverter;
import com.audelia.backend.loginregistration.loginregistration.util.converter.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/teacher")
public class TeacherController {

    @Autowired
    private DtoConverter dtoConverter;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassStudentRepository classStudentRepository;

    @Autowired
    private ClassSubjectRepository classSubjectRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private ExaminationRepository examinationRepository;

    @GetMapping("/getAllStudentsInClass")
    public List<StudentDTO> getAllStudentsInClass(@RequestParam("grade") String grade,@RequestParam("id") String id,@RequestParam("year") String year) {

        List<StudentDTO> studentDTOS = new ArrayList<>();

        for(ClassStudent classStudent : classStudentRepository.findByAClass(classRepository.findByClassID(new ClassID(grade,id,year)))){
            studentDTOS.add((StudentDTO) dtoConverter.convertToDTO(classStudent.getStudent()));
        }
      return studentDTOS;
    }


    @GetMapping("/getAllStudents")
    public List<StudentDTO> getAllStudents(){

        List<StudentDTO> studentDTOS = new ArrayList<>();
        for(Student student : studentRepository.findAll()){
            studentDTOS.add((StudentDTO) dtoConverter.convertToDTO(student));
        }
        return studentDTOS;
    }


    @GetMapping("/getClassTeacherClasses")
    public List<ClassDTO> getClassTeacherClasses(@RequestParam("regNo") String registrationNumber){

        List<ClassDTO> classDTOS = new ArrayList<>();
        Teacher teacher = teacherRepository.findByRegistrationNumber(registrationNumber);
        for(Class class1: classRepository.findByTeacher(teacher)){
            classDTOS.add((ClassDTO) dtoConverter.convertToDTO(class1));
        }
        return classDTOS;
    }

    @GetMapping("/assignStudentsToClass")
    public boolean assignStudentsToClass(@RequestParam("grade") String grade, @RequestParam("id") String id, @RequestParam("year") String year, @RequestParam("student") String student){

        boolean state = true;

        Student student1 = studentRepository.findByRegistrationNumber(student);
        Class aclass = classRepository.findByClassID(new ClassID(grade,id,year));

        state = state & classStudentRepository.save(new ClassStudent(aclass,student1)) != null ? true : false;

        return state;
    }
    @GetMapping ("/getTeacherClassSubject")
    public List<SubjectDTO> getTeacherClassSubject(@RequestParam("grade") String grade, @RequestParam("id") String id, @RequestParam("year") String year, @RequestParam("teacher") String teacher)
    {

        Teacher teacher1 = teacherRepository.findByRegistrationNumber(teacher);
        Class class1 = classRepository.findByClassID(new ClassID(grade,id,year));

        List<SubjectDTO> subjectDTOS = new ArrayList<>();


        for(ClassSubject classSubject: classSubjectRepository.findAllByTeacherAndAClass(teacher1, class1)){

            subjectDTOS.add((SubjectDTO) dtoConverter.convertToDTO(classSubject.getSubject()));

        }
        return subjectDTOS;

    }
//    @GetMapping("/getTeacherClasses")
//    public List<NameDTO> getTeacherClasses(@RequestParam("teacherID") String teacherID){
//
//        List<NameDTO> nameDTOList = new ArrayList<>();
//
//        Teacher teacher = teacherRepository.findByRegistrationNumber(teacherID);
//        List<Class> classList = classRepository.findByTeacher(teacher);
//
//        NameDTO nameDTO = new NameDTO("My Classes");
//        List<NameDTO> childrenList = new ArrayList<>();
//        for(Class aclass : classList){
//            childrenList.add(new NameDTO(aclass.getClassID().getGrade() + " " + aclass.getClassID().getId() + " " + aclass.getClassID().getYear()));
//        }
//        nameDTO.setChildren(childrenList);
//        nameDTOList.add(nameDTO);
//
//
////        NameDTO nameDTO1 = new NameDTO("Other Classes");
////
////        List<ClassSubject> classSubjectList = classSubjectRepository.findAllByTeacher(teacher);
////        List<NameDTO> childrenList1 = new ArrayList<>();
////        for(ClassSubject classSubject : classSubjectList){
////            childrenList1.add(new NameDTO(""))
////        }
//
//        return nameDTOList;
//    }

    @GetMapping("/getTeacherClassSubjects")
    public List<ClassSubjectDTO> getTeacherClassSubjects(@RequestParam("regNo") String registrationNumber){

        List<ClassSubjectDTO> classSubjectDTOS = new ArrayList<>();
        Teacher teacher = teacherRepository.findByRegistrationNumber(registrationNumber);
        for(ClassSubject  classSubject : classSubjectRepository.findAllByTeacher(teacher)){
            classSubjectDTOS.add((ClassSubjectDTO) dtoConverter.convertToDTO(classSubject));
        }
        return classSubjectDTOS;
    }

    @GetMapping("/getAllStudentsInClassStudent")
    public List<ClassStudentDTO> getAllStudentsInClassStudent(@RequestParam("grade") String grade,@RequestParam("id") String id,@RequestParam("year") String year) {

        List<ClassStudentDTO> classStudentDTOS = new ArrayList<>();
//        Class aClass = classRepository.findByClassID(classID);
        for (ClassStudent classStudent : classStudentRepository.findByAClass(classRepository.findByClassID(new ClassID(grade,id,year)))) {
            classStudentDTOS.add((ClassStudentDTO) dtoConverter.convertToDTO(classStudent));
        }
        return classStudentDTOS;

    }



}