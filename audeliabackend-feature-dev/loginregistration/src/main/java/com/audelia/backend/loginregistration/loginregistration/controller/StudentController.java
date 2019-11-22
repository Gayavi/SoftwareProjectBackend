package com.audelia.backend.loginregistration.loginregistration.controller;

import com.audelia.backend.loginregistration.loginregistration.dto.ClassDTO;
import com.audelia.backend.loginregistration.loginregistration.model.Class;
import com.audelia.backend.loginregistration.loginregistration.model.ClassStudent;
import com.audelia.backend.loginregistration.loginregistration.model.Student;
import com.audelia.backend.loginregistration.loginregistration.repository.ClassStudentRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.ClassSubjectRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.StudentClassSubjectRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.StudentRepository;
import com.audelia.backend.loginregistration.loginregistration.util.converter.DtoConverter;
import com.audelia.backend.loginregistration.loginregistration.util.converter.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    private DtoConverter dtoConverter;

    @Autowired
    private EntityConverter entityConverter;


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassSubjectRepository classSubjectRepository;

    @Autowired
    private ClassStudentRepository classStudentRepository;

    @Autowired
    private StudentClassSubjectRepository studentClassSubjectRepository;


    @GetMapping("/getStudentClasses")
    public List<ClassDTO> getStudentClasses(@RequestParam("regNo") String registrationNumber){

        List<ClassDTO> classDTOS = new ArrayList<>();

        Student student = studentRepository.findByRegistrationNumber(registrationNumber);

        for(ClassStudent classStudent : classStudentRepository.findAllByStudent(student)){
            classDTOS.add((ClassDTO) dtoConverter.convertToDTO(classStudent));
        }
        return classDTOS;
    }



}
