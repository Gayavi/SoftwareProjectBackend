package com.audelia.backend.loginregistration.loginregistration.repository;

import com.audelia.backend.loginregistration.loginregistration.model.ClassSubject;
import com.audelia.backend.loginregistration.loginregistration.model.LearningMaterials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearningMaterialsRepository extends CrudRepository<LearningMaterials,Integer> {
    List<LearningMaterials> findAllByClassSubject(ClassSubject classSubject);
}
