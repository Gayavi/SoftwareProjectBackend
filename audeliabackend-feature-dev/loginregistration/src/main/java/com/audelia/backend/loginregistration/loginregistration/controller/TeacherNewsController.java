package com.audelia.backend.loginregistration.loginregistration.controller;

import com.audelia.backend.loginregistration.loginregistration.dto.AdminNewsDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.TeacherNewsDTO;
import com.audelia.backend.loginregistration.loginregistration.model.Admin;
import com.audelia.backend.loginregistration.loginregistration.model.AdminNews;
import com.audelia.backend.loginregistration.loginregistration.model.TeacherNews;
import com.audelia.backend.loginregistration.loginregistration.repository.AdminRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.ArticleRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.TeacherNewsRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.TeacherRepository;
import com.audelia.backend.loginregistration.loginregistration.util.converter.DtoConverter;
import com.audelia.backend.loginregistration.loginregistration.util.converter.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/teacherNews")
public class TeacherNewsController {

    @Autowired
    private DtoConverter dtoConverter;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private TeacherNewsRepository teacherNewsRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private AdminRepository adminRepository;



    @Autowired
    private ArticleRepository articleRepository;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm a");

    @PostMapping("/saveTeacherNews")
    public boolean saveTeacherNews(@RequestBody TeacherNewsDTO teacherNewsDTO){
        TeacherNews teacherNews = (TeacherNews) entityConverter.convertToEntity(teacherNewsDTO);
        teacherNews.setStatus("PENDING");
        teacherNews.setDate(simpleDateFormat.format(new Date()));
        return teacherNewsRepository.save(teacherNews) != null ? true : false;
    }

    @GetMapping("/getAllPendingNews")
    public List<TeacherNewsDTO> getAllPendingNews(){

        List<TeacherNewsDTO> teacherNewsDTOS = new ArrayList<>();
        for(TeacherNews teacherNews : teacherNewsRepository.findAllByStatus("PENDING")){
            teacherNewsDTOS.add((TeacherNewsDTO) dtoConverter.convertToDTO(teacherNews));
        }
        return teacherNewsDTOS;
    }
    @GetMapping("/getAllApprovedNews")
    public List<TeacherNewsDTO> getAllApprovedNews(){

        List<TeacherNewsDTO> teacherNewsDTOS = new ArrayList<>();
        for(TeacherNews teacherNews : teacherNewsRepository.findAllByStatus("CONFIRMED")){
            teacherNewsDTOS.add((TeacherNewsDTO) dtoConverter.convertToDTO(teacherNews));
        }
        return teacherNewsDTOS;

    }


    @GetMapping("/getAllRejectedNews")
    public List<TeacherNewsDTO> getAllRejectedNews(){

        List<TeacherNewsDTO> teacherNewsDTOS = new ArrayList<>();
        for(TeacherNews teacherNews : teacherNewsRepository.findAllByStatus("REJECTED")){
            teacherNewsDTOS.add((TeacherNewsDTO) dtoConverter.convertToDTO(teacherNews));
        }
        return teacherNewsDTOS;
    }

    @GetMapping("/approveTeacherNews")
    public boolean approveTeacherNews(@RequestParam("id") int id, @RequestParam("adminID") String adminID){
        Admin admin = adminRepository.findByRegistrationNumber(adminID);
        return teacherNewsRepository.updateStatus("CONFIRMED", admin, id)> 0 ? true : false;
    }

    @GetMapping("/rejectTeacherNews")
    public boolean rejectTeacherNews(@RequestParam("id") int id, @RequestParam("adminID") String adminID){
        Admin admin = adminRepository.findByRegistrationNumber(adminID);
        return teacherNewsRepository.updateStatus("REJECTED", admin, id)> 0 ? true : false;
    }


}
