package com.audelia.backend.loginregistration.loginregistration.controller;


import com.audelia.backend.loginregistration.loginregistration.dto.ExaminationDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.FileDTO;
import com.audelia.backend.loginregistration.loginregistration.dto.LearningMaterialsDTO;
import com.audelia.backend.loginregistration.loginregistration.model.ClassID;
import com.audelia.backend.loginregistration.loginregistration.model.Examination;
import com.audelia.backend.loginregistration.loginregistration.model.LearningMaterials;
import com.audelia.backend.loginregistration.loginregistration.repository.*;
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
@RequestMapping("api/v1/assignment")
public class AssignmentController {

    @Autowired
    private EntityConverter entityConverter;

    @Autowired
    private DtoConverter dtoConverter;

    @Autowired
    private ExaminationRepository examinationRepository;

    @Autowired
    private LearningMaterialsRepository learningMaterialsRepository;

    @Autowired
    private ClassSubjectRepository classSubjectRepository;

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm a");

    @PostMapping("/saveExamination")
    public boolean saveExamination(@RequestBody FileDTO fileDTO){
        Examination examination = new Examination();
        examination.setClassSubject(classSubjectRepository.findByAClassAndSubject(classRepository.findByClassID(new ClassID(fileDTO.getGrade(),fileDTO.getId(),fileDTO.getYear())),subjectRepository.findBySubjectId(fileDTO.getSubjectID())));
        examination.setDescription(fileDTO.getDescription());
        examination.setSourceUri(fileDTO.getSubjectID() + " " + fileDTO.getDescription() + " " + ".pdf");
        examination.setDate(simpleDateFormat.format(new Date()));
        examination.setDueDate(fileDTO.getDueDate());
        return examinationRepository.save(examination) != null ? true : false;
    }

    @PostMapping("/saveMaterials")
    public boolean saveMaterials(@RequestBody FileDTO fileDTO){

        LearningMaterials learningMaterials = new LearningMaterials();
        learningMaterials.setClassSubject(classSubjectRepository.findByAClassAndSubject(classRepository.findByClassID(new ClassID(fileDTO.getGrade(),fileDTO.getId(),fileDTO.getYear())),subjectRepository.findBySubjectId(fileDTO.getSubjectID())));
        learningMaterials.setDescription(fileDTO.getDescription());
        learningMaterials.setDate(simpleDateFormat.format(new Date()));
        learningMaterials.setMaterialUri(fileDTO.getSubjectID() + " " + fileDTO.getDescription() + " " + ".pdf");

        return learningMaterialsRepository.save(learningMaterials) != null ? true : false;
    }


    @GetMapping("/getAllAssignments")
    public List<ExaminationDTO> getAllAssignmentsByClassANDSubjectID(@RequestParam("grade") String grade,@RequestParam("id") String id,@RequestParam("year")String year,@RequestParam("subjectID") String subjectID){

       List<Examination> examinationList =  examinationRepository.findAllByClassSubject(classSubjectRepository.findByAClassAndSubject(classRepository.findByClassID(new ClassID(grade,id,year)),subjectRepository.findBySubjectId(subjectID)));

        List<ExaminationDTO> examinationDTOS = new ArrayList<>();

        for(Examination examination : examinationList){
            examinationDTOS.add((ExaminationDTO) dtoConverter.convertToDTO(examination));
        }

        return examinationDTOS;

    }

    @GetMapping("/getAllMaterials")
    public List<LearningMaterialsDTO> getAllLearningMaterilasByClassANDSubjectID(@RequestParam("grade") String grade,@RequestParam("id") String id,@RequestParam("year")String year,@RequestParam("subjectID") String subjectID){

        List<LearningMaterials> learningMaterials =  learningMaterialsRepository.findAllByClassSubject(classSubjectRepository.findByAClassAndSubject(classRepository.findByClassID(new ClassID(grade,id,year)),subjectRepository.findBySubjectId(subjectID)));

        List<LearningMaterialsDTO> learningMaterialsDTOS = new ArrayList<>();

        for(LearningMaterials learningMaterials1 : learningMaterials){
            learningMaterialsDTOS.add((LearningMaterialsDTO) dtoConverter.convertToDTO(learningMaterials1));
        }

        return learningMaterialsDTOS;

    }






}
