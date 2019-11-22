package com.audelia.backend.loginregistration.loginregistration.dto;

import com.audelia.backend.loginregistration.loginregistration.util.enums.UserType;

public class UserDTO {

    private AdminDTO adminDTO;
    private ParentDTO parentDTO;
    private StudentDTO studentDTO;
    private TeacherDTO teacherDTO;
    private UserType userType;


    public UserDTO() {
    }

    public UserDTO(AdminDTO adminDTO, ParentDTO parentDTO, StudentDTO studentDTO, TeacherDTO teacherDTO, UserType userType) {
        this.adminDTO = adminDTO;
        this.parentDTO = parentDTO;
        this.studentDTO = studentDTO;
        this.teacherDTO = teacherDTO;
        this.userType = userType;
    }


    public AdminDTO getAdminDTO() {
        return adminDTO;
    }

    public void setAdminDTO(AdminDTO adminDTO) {
        this.adminDTO = adminDTO;
    }

    public ParentDTO getParentDTO() {
        return parentDTO;
    }

    public void setParentDTO(ParentDTO parentDTO) {
        this.parentDTO = parentDTO;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public TeacherDTO getTeacherDTO() {
        return teacherDTO;
    }

    public void setTeacherDTO(TeacherDTO teacherDTO) {
        this.teacherDTO = teacherDTO;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
