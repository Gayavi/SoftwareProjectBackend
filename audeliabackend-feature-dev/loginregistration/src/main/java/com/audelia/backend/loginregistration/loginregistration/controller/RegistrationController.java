package com.audelia.backend.loginregistration.loginregistration.controller;

import com.audelia.backend.loginregistration.loginregistration.dto.AdminDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.ParentDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.StudentDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.TeacherDTO;
import com.audelia.backend.loginregistration.loginregistration.repository.AdminRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.ParentRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.StudentRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.TeacherRepository;
import com.audelia.backend.loginregistration.loginregistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/teacherExists")
    public boolean teacherExists(@RequestParam("registrationNumber") String registrationNumber){

        if(userService.loadTeacherByUsername(registrationNumber) != null){
            return true;
        }else{
            return false;
        }
    }

    @GetMapping("/parentExists")
    public boolean parentExists(@RequestParam("registrationNumber") String registrationNumber){

        if(userService.loadParentByUsername(registrationNumber) != null){
            return true;
        }else{
            return false;
        }
    }


    @GetMapping("/studentExists")
    public boolean studentExists(@RequestParam("registrationNumber") String registrationNumber){

        if(userService.loadStudentByUsername(registrationNumber) != null){
            return true;
        }else{
            return false;
        }
    }


    @GetMapping("/adminExists")
    public boolean adminExists(@RequestParam("registrationNumber") String registrationNumber){

        if(userService.loadAdminByUsername(registrationNumber) != null){
            return true;
        }else{
            return false;
        }
    }

    @PostMapping("/registerTeacher")
    public TeacherDTO registerTeacher(@RequestBody TeacherDTO teacherDTO){
        return userService.registerTeacher(teacherDTO);
    }

    @PostMapping("/registerAdmin")
    public AdminDTO registerAdmin(@RequestBody AdminDTO adminDTO){


        System.out.println("============== " + adminDTO.getContactNumber());

        return  userService.registerAdmin(adminDTO);
    }

    @PostMapping("/registerStudent")
    public StudentDTO registerStudent(@RequestBody  StudentDTO studentDTO){
        return userService.registerStudent(studentDTO);
    }

    @PostMapping("/registerParent")
    public ParentDTO registerParent(@RequestBody ParentDTO parentDTO){
        return userService.registerParent(parentDTO);
    }

    @GetMapping("/getAllParents")
    public List<ParentDTO> getAllParents(){
        return userService.findAll();
    }
}
