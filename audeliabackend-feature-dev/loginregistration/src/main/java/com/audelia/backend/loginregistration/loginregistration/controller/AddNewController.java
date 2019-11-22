package com.audelia.backend.loginregistration.loginregistration.controller;


import com.audelia.backend.loginregistration.loginregistration.dto.ClassDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.SubjectDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.TeacherDTO;
import com.audelia.backend.loginregistration.loginregistration.model.Class;
import com.audelia.backend.loginregistration.loginregistration.model.ClassID;
import com.audelia.backend.loginregistration.loginregistration.model.Subject;
import com.audelia.backend.loginregistration.loginregistration.model.Teacher;
import com.audelia.backend.loginregistration.loginregistration.repository.ClassRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.SubjectRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.TeacherRepository;
import com.audelia.backend.loginregistration.loginregistration.util.converter.DtoConverter;
import com.audelia.backend.loginregistration.loginregistration.util.converter.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/addnew")
public class AddNewController {


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

    @PostMapping("/classExists")
    public boolean findClassExists(@RequestBody ClassDTO classDTO){

        System.out.println("================ " + classDTO.getGrade() + " " + classDTO.getId() + " " + classDTO.getYear());

        if(classRepository.findByClassID(new ClassID(classDTO.getGrade(),classDTO.getId(),classDTO.getYear())) != null) {
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("/saveClass")
    public ClassDTO saveClass(@RequestBody ClassDTO c){
        System.out.println(c.getTeacher().getRegistrationNumber());
        return (ClassDTO) dtoConverter.convertToDTO(classRepository.save( (Class) entityConverter.convertToEntity(c)));
    }

    @GetMapping("/subjectExists")
    public boolean findSubjectExists(@RequestParam("subjectID") String subjectID){
        if(subjectRepository.findBySubjectId(subjectID) != null){
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("/saveSubject")
    public Subject saveSubject(@RequestBody Subject subject){
        return subjectRepository.save(subject);
    }

    @GetMapping("/getAllTeachers")
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    @GetMapping("/getClassByID")
    public ClassDTO getClassByID(@RequestParam("grade") String grade,@RequestParam("id") String id,@RequestParam("year") String year){

    return  (ClassDTO) dtoConverter.convertToDTO(classRepository.findByClassID(new ClassID(grade,id,year)));
    }

}
