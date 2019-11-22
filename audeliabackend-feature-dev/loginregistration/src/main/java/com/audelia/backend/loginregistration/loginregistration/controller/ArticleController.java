package com.audelia.backend.loginregistration.loginregistration.controller;


import com.audelia.backend.loginregistration.loginregistration.dto.ArticlesDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.TeacherNewsDTO;
import com.audelia.backend.loginregistration.loginregistration.model.Articles;
import com.audelia.backend.loginregistration.loginregistration.model.Teacher;
import com.audelia.backend.loginregistration.loginregistration.model.TeacherNews;
import com.audelia.backend.loginregistration.loginregistration.repository.ArticleRepository;
import com.audelia.backend.loginregistration.loginregistration.repository.StudentRepository;
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
@RequestMapping("api/v1/articles")
public class ArticleController {

    @Autowired
    private DtoConverter dtoConverter;

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ArticleRepository articleRepository;


    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm a");

    @PostMapping("/saveArticle")
    public boolean saveAllArticles(@RequestBody ArticlesDTO articlesDTO){
        Articles articles = (Articles) entityConverter.convertToEntity(articlesDTO);
        articles.setStatus("PENDING");
        articles.setDate(simpleDateFormat.format(new Date()));
        return articleRepository.save(articles) != null ? true : false;
    }

    @GetMapping("/getAllPendingArticles")
    public List<ArticlesDTO> getAllPendingArticles(){

        List<ArticlesDTO> articlesDTOS = new ArrayList<>();
        for(Articles articles : articleRepository.findByStatus("PENDING")){
            articlesDTOS.add((ArticlesDTO) dtoConverter.convertToDTO(articles));
        }
        return articlesDTOS;
    }

    @GetMapping("/getAllApprovedArticles")
    public List<ArticlesDTO> getAllApprovedArticles(){

        List<ArticlesDTO> articlesDTOS = new ArrayList<>();
        for(Articles articles : articleRepository.findByStatus("CONFIRMED")){
            articlesDTOS.add((ArticlesDTO) dtoConverter.convertToDTO(articles));
        }
        return articlesDTOS;
    }

    @GetMapping("/getAllRejectedArticles")
    public List<ArticlesDTO> getAllRejectedArticles(){

        List<ArticlesDTO> articlesDTOS = new ArrayList<>();
        for(Articles articles : articleRepository.findByStatus("REJECTED")){
            articlesDTOS.add((ArticlesDTO) dtoConverter.convertToDTO(articles));
        }
        return articlesDTOS;
    }


    @GetMapping("/approveArticle")
    public boolean approveArticle(@RequestParam("id") int id,@RequestParam("teacherID") String teacherID){

        Teacher teacher = teacherRepository.findByRegistrationNumber(teacherID);
        System.out.println("============= " + teacherID + " ========= "+ teacher.getEmail());
        return articleRepository.updateArticleStatus("CONFIRMED",teacher,id) > 0 ? true : false;

    }

    @GetMapping("/rejectArticle")
    public boolean rejectArticle(@RequestParam("id") int id,@RequestParam("teacherID") String teacherID){
        Teacher teacher = teacherRepository.findByRegistrationNumber(teacherID);
        return articleRepository.updateArticleStatus("REJECTED",teacher,id)  > 0 ? true : false;
    }

}
