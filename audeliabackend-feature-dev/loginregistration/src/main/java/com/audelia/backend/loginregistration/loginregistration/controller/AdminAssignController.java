package com.audelia.backend.loginregistration.loginregistration.controller;

import com.audelia.backend.loginregistration.loginregistration.dto.ClassSubjectDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.SubjectDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.TeacherDTO;
import com.audelia.backend.loginregistration.loginregistration.model.Class;
import com.audelia.backend.loginregistration.loginregistration.model.*;
import com.audelia.backend.loginregistration.loginregistration.repository.*;
import com.audelia.backend.loginregistration.loginregistration.util.converter.DtoConverter;
import com.audelia.backend.loginregistration.loginregistration.util.converter.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/adminassign")
public class AdminAssignController {
    @Autowired
    private DtoConverter dtoConverter;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeacherRepository teacherRepository;


    @Autowired
    private ClassSubjectRepository classSubjectRepository;

    @GetMapping("/getClassSubjectsByID")
    public List<ClassSubjectDTO> getClassSubjectsByID(@RequestParam("grade") String grade,@RequestParam("id") String id,@RequestParam("year") String year){

        System.out.println(grade + "  " + id + "   " + year);

        List<ClassSubjectDTO> classSubjectDTOS = new ArrayList<>();


       Class aclass = classRepository.findByClassID(new ClassID(grade,id,year));

        List<ClassSubject> classSubjects = classSubjectRepository.findAllByAClass(aclass);

       for(ClassSubject classSubject : classSubjects){
           classSubjectDTOS.add((ClassSubjectDTO) dtoConverter.convertToDTO(classSubject));
       }

       return classSubjectDTOS;


    }


    @GetMapping("/getAllSubjects")
    public List<SubjectDTO> getAllSubjects(){

        List<SubjectDTO> subjectDTOS = new ArrayList<>();
        for(Subject subject : subjectRepository.findAll()){
            subjectDTOS.add((SubjectDTO) dtoConverter.convertToDTO(subject));
        }
        return subjectDTOS;
    }

    @GetMapping("/getAllTeachers")
    public List<TeacherDTO> getAllTeachers(){

        List<TeacherDTO> teacherDTOS = new ArrayList<>();
        for(Teacher teacher : teacherRepository.findAll()){
            teacherDTOS.add((TeacherDTO) dtoConverter.convertToDTO(teacher));
        }
        return teacherDTOS;
    }

    @PostMapping("/saveClassSubject")
    public boolean saveClassSubject(@RequestBody ClassSubjectDTO classSubjectDTO){

        System.out.println("============= " + classSubjectDTO.getaClass().getGrade() + "== " + classSubjectDTO.getaClass().getId());

        ClassSubject classSubject = (ClassSubject) entityConverter.convertToEntity(classSubjectDTO);


        System.out.println("============ " + classSubject.getaClass().getClassID().getYear());
        System.out.println("============ " + classSubject.getaClass().getClassID().getGrade());
        System.out.println("============ " + classSubject.getaClass().getClassID().getId());

        classSubjectRepository.save(classSubject);

//        if(  classSubjectRepository.save() != null ){
//            return true;
//        }else{
//            return false;
//        }

        return true;
    }

//    @GetMapping("/getAllClassSubjects")
//    public List<ClassSubjectDTO> getAllClassSubjects(){
//        List<ClassSubjectDTO> classSubjectDTOS = new ArrayList<>();
//
//        List<ClassSubject> classSubjects = classSubjectRepository.findByAClass(new ClassID("10","1","1"));
//        for(ClassSubject classSubject : classSubjects){
//            classSubjectDTOS.add((ClassSubjectDTO) dtoConverter.convertToDTO(classSubject));
//        }
//        return classSubjectDTOS;
//    }

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/classSubjectExists")
    public boolean classSubjectExists(@RequestParam("grade") String grade,@RequestParam("id") String id,@RequestParam("year") String year,@RequestParam("subjectID") String subjectID){
        return classSubjectRepository.existsByAClassAndSubject(classRepository.findByClassID(new ClassID(grade,id,year)),subjectRepository.findBySubjectId(subjectID));
    }

}
