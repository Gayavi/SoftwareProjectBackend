package com.audelia.backend.loginregistration.loginregistration.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/test")
public class TestController {

    @GetMapping("/test")
    public String test(){
        System.out.println();
        Path rootLocation = Paths.get("upload-dir");
        System.out.println("=========== " + rootLocation);
        return "Testing ============== ";
    }


}
