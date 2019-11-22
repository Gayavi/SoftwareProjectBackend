package com.audelia.backend.loginregistration.loginregistration.controller;

import com.audelia.backend.loginregistration.loginregistration.dto.AdminDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.ParentDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.StudentDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.TeacherDTO;
import com.audelia.backend.loginregistration.loginregistration.model.Admin;
import com.audelia.backend.loginregistration.loginregistration.model.Parent;
import com.audelia.backend.loginregistration.loginregistration.model.Student;
import com.audelia.backend.loginregistration.loginregistration.model.Teacher;
import com.audelia.backend.loginregistration.loginregistration.repository.AdminRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.ParentRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.StudentRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.TeacherRepository;
import com.audelia.backend.loginregistration.loginregistration.util.converter.DtoConverter;
import com.audelia.backend.loginregistration.loginregistration.util.converter.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/people")
public class PeopleController {
    @Autowired
    private DtoConverter dtoConverter;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository1;

    @GetMapping("/getAllStudents")
    public List<StudentDTO> getAllStudents(){

        List<StudentDTO> studentDTOS = new ArrayList<>();
        for(Student student : studentRepository.findAll()){
            studentDTOS.add((StudentDTO) dtoConverter.convertToDTO(student));
        }
        return studentDTOS;
    }

    @GetMapping("/getAllAdmins")
    public List<AdminDTO> getAllAdmins(){

        List<AdminDTO> adminDTOS = new ArrayList<>();
        for(Admin admin : adminRepository.findAll()){
            adminDTOS.add((AdminDTO) dtoConverter.convertToDTO(admin));
        }
        return adminDTOS;
    }



    @GetMapping("/getAllParents")
    public List<ParentDTO> getAllParents(){

        List<ParentDTO> parentDTOS = new ArrayList<>();
        for(Parent parent : parentRepository.findAll()){
            parentDTOS.add((ParentDTO) dtoConverter.convertToDTO(parent));
        }
        return parentDTOS;
    }


    @GetMapping("/getAllTeachers")
    public List<TeacherDTO> getAllTeachers(){

        List<TeacherDTO> teacherDTOS = new ArrayList<>();
        for(Teacher teacher : teacherRepository.findAll()){
            teacherDTOS.add((TeacherDTO) dtoConverter.convertToDTO(teacher));
        }
        return teacherDTOS;
    }

    @GetMapping("/getChildren")
    public List<StudentDTO> getChildren(@RequestParam("regNo") String registrationNumber) {
        List<StudentDTO> studentDTOS = new ArrayList<>();

        Parent parent = parentRepository.findByRegistrationNumber(registrationNumber);
        if(parent != null){
            for(Student student : studentRepository.findAllByParent(parent)){
                studentDTOS.add((StudentDTO) dtoConverter.convertToDTO(student));
            }
            return studentDTOS;
        }
        return null;
    }
}
