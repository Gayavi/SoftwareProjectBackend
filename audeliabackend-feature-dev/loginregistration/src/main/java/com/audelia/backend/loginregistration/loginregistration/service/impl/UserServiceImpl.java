package com.audelia.backend.loginregistration.loginregistration.service.impl;

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
import com.audelia.backend.loginregistration.loginregistration.service.UserService;
import com.audelia.backend.loginregistration.loginregistration.util.converter.DtoConverter;
import com.audelia.backend.loginregistration.loginregistration.util.converter.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;


    private PasswordEncoder passwordEncoder;

    @Autowired
    private DtoConverter dtoConverter;

    @Autowired
    private EntityConverter entityConverter;


    public UserServiceImpl() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public AdminDTO loadAdminByUsername(String username) {

        AdminDTO adminDTO =  (AdminDTO) dtoConverter.convertToDTO(adminRepository.findByRegistrationNumber(username));
      //  System.out.println(" --------------- " + adminDTO.getProfile_uri());
        return adminDTO;
    }

    @Override
    public ParentDTO loadParentByUsername(String username) {
        Parent parent = parentRepository.findByRegistrationNumber(username);
        return (ParentDTO) dtoConverter.convertToDTO(parent);
    }

    @Override
    public StudentDTO loadStudentByUsername(String username) {
        return (StudentDTO) dtoConverter.convertToDTO(studentRepository.findByRegistrationNumber(username));
    }

    @Override
    public TeacherDTO loadTeacherByUsername(String username) {
        return (TeacherDTO) dtoConverter.convertToDTO(teacherRepository.findByRegistrationNumber(username));
    }

    @Override
    public TeacherDTO registerTeacher(TeacherDTO teacherDTO) {
        teacherDTO.setPassword(passwordEncoder.encode(teacherDTO.getPassword()));
        Teacher teacher = (Teacher) entityConverter.convertToEntity(teacherDTO);
        return (TeacherDTO) dtoConverter.convertToDTO(teacherRepository.save(teacher));
    }

    @Override
    public AdminDTO registerAdmin(AdminDTO adminDTO) {
        adminDTO.setPassword(passwordEncoder.encode(adminDTO.getPassword()));
        return (AdminDTO) dtoConverter.convertToDTO(adminRepository.save((Admin) entityConverter.convertToEntity(adminDTO)));
    }

    @Override
    public StudentDTO registerStudent(StudentDTO studentDTO) {
        studentDTO.setPassword(passwordEncoder.encode(studentDTO.getPassword()));
        return (StudentDTO) dtoConverter.convertToDTO(studentRepository.save((Student) entityConverter.convertToEntity(studentDTO)));
    }

    @Override
    public ParentDTO registerParent(ParentDTO parentDTO) {
        parentDTO.setPassword(passwordEncoder.encode(parentDTO.getPassword()));
        return  (ParentDTO) dtoConverter.convertToDTO(parentRepository.save((Parent) entityConverter.convertToEntity(parentDTO)));
    }

    @Override
    public List<ParentDTO> findAll() {
        List<ParentDTO> parentDTOS = new ArrayList<>();
        for(Parent parent : parentRepository.findAll()){
            parentDTOS.add((ParentDTO) dtoConverter.convertToDTO(parent));
        }
        return parentDTOS;
    }


}
