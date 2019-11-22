package com.audelia.backend.loginregistration.loginregistration;

import com.audelia.backend.loginregistration.loginregistration.model.Admin;
import com.audelia.backend.loginregistration.loginregistration.model.Parent;
import com.audelia.backend.loginregistration.loginregistration.model.Student;
import com.audelia.backend.loginregistration.loginregistration.model.Teacher;
import com.audelia.backend.loginregistration.loginregistration.repository.AdminRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.ParentRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.StudentRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DummyDataLoader implements ApplicationRunner {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ParentRepository parentRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        this.passwordEncoder = new BCryptPasswordEncoder();


        try{

            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");


                java.util.Date utilDate = format.parse("1997/12/24");
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                System.out.println(sqlDate);

            adminRepository.save(new Admin("A001","Hiruni Maleesha","Female",passwordEncoder.encode("123"),"Principal","hmshamindri5@gmail.com","0769068923","Hiruni MaleeshaFemaleA001.jpeg"));

           Parent parent =  parentRepository.save(new Parent("P001","Merry Violet","Kuliyapitiya","Female","violet@gmail.com",passwordEncoder.encode("123"),"0771735008"));

            studentRepository.save(new Student("S001",parent,"Amesh M Jayaweera",sqlDate,"MALE","Kuliyapitiya","0771735008",passwordEncoder.encode(("123")),""));

            teacherRepository.save(new Teacher("T001","Mahesh Jayawardhana","Male","mahesh78@gmail.com",passwordEncoder.encode("123"),"0771735008"));



        }catch (Exception e){
            System.out.println("========= " + e.getMessage());
        }

    }

}
