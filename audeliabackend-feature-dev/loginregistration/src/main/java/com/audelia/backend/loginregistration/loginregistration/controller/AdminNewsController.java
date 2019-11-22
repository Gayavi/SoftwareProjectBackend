package com.audelia.backend.loginregistration.loginregistration.controller;

import com.audelia.backend.loginregistration.loginregistration.dto.AdminNewsDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.ParentDTO;
import com.audelia.backend.loginregistration.loginregistration.model.AdminNews;
import com.audelia.backend.loginregistration.loginregistration.model.Parent;
import com.audelia.backend.loginregistration.loginregistration.repository.AdminNewsRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.AdminRepository;
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
@RequestMapping("api/v1/adminNews")
public class AdminNewsController {
    @Autowired
    private DtoConverter dtoConverter;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private AdminNewsRepository adminNewsRepository;

    @Autowired
    private AdminRepository adminRepository;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm a");

    @PostMapping("/saveAdminNews")
    public boolean saveAdminNews(@RequestBody AdminNewsDTO adminNewsDTO){
        AdminNews adminNews = (AdminNews) entityConverter.convertToEntity(adminNewsDTO);
        adminNews.setDate(simpleDateFormat.format(new Date()));
        return adminNewsRepository.save(adminNews) != null ? true : false;
    }


    @GetMapping("/getAllAdminNews")
    public List<AdminNewsDTO> getAllAdminNews(){

        List<AdminNewsDTO> adminNewsDTOS = new ArrayList<>();
        for(AdminNews adminNews : adminNewsRepository.findAll()){
            adminNewsDTOS.add((AdminNewsDTO) dtoConverter.convertToDTO(adminNews));
        }
        return adminNewsDTOS;
    }



}
