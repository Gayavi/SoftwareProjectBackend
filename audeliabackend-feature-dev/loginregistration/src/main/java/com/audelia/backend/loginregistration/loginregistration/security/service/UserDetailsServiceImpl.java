package com.audelia.backend.loginregistration.loginregistration.security.service;



import com.audelia.backend.loginregistration.loginregistration.model.Admin;
import com.audelia.backend.loginregistration.loginregistration.model.Parent;
import com.audelia.backend.loginregistration.loginregistration.model.Student;
import com.audelia.backend.loginregistration.loginregistration.model.Teacher;
import com.audelia.backend.loginregistration.loginregistration.repository.AdminRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.ParentRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.StudentRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.TeacherRepository;
import com.audelia.backend.loginregistration.loginregistration.security.model.SpringSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String registrationNumber;
        String password;

        if(Pattern.matches("A\\d\\d\\d",username)){
            Admin admin = adminRepository.findByRegistrationNumber(username);
            registrationNumber = admin.getRegistrationNumber();
            password = admin.getPassword();
        }else if(Pattern.matches("S\\d\\d\\d",username)){
            Student student = studentRepository.findByRegistrationNumber(username);
            registrationNumber = student.getRegistrationNumber();
            password = student.getPassword();
        }else if(Pattern.matches("T\\d\\d\\d",username)){
            Teacher teacher = teacherRepository.findByRegistrationNumber(username);
            registrationNumber =  teacher.getRegistrationNumber();
            password = teacher.getPassword();
        }else if(Pattern.matches("P\\d\\d\\d",username)){
            Parent parent = parentRepository.findByRegistrationNumber(username);
            registrationNumber = parent.getRegistrationNumber();
            password = parent.getPassword();
        }else{
            registrationNumber = "";
            password = "";
        }

        if (registrationNumber == "") {
            throw new UsernameNotFoundException(String.format("No appUser found with username '%s'.", username));
        } else {
            return new SpringSecurityUser(
                   registrationNumber,
                    password
            );
        }
    }

}
