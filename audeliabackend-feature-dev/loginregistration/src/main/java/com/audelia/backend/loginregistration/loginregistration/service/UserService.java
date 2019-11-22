package com.audelia.backend.loginregistration.loginregistration.service;

import com.audelia.backend.loginregistration.loginregistration.dto.AdminDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.ParentDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.StudentDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.TeacherDTO;

import java.util.List;

public interface UserService {

    AdminDTO loadAdminByUsername(String username);
    ParentDTO loadParentByUsername(String username);
    StudentDTO loadStudentByUsername(String username);
    TeacherDTO loadTeacherByUsername(String username);

    TeacherDTO registerTeacher(TeacherDTO teacherDTO);
    AdminDTO registerAdmin(AdminDTO adminDTO);
    StudentDTO registerStudent(StudentDTO studentDTO);
    ParentDTO registerParent(ParentDTO parentDTO);


    List<ParentDTO> findAll();
}
