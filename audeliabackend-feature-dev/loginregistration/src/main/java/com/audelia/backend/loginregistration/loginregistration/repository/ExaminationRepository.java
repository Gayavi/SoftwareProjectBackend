package com.audelia.backend.loginregistration.loginregistration.repository;

import com.audelia.backend.loginregistration.loginregistration.model.ClassSubject;
import com.audelia.backend.loginregistration.loginregistration.model.Examination;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExaminationRepository extends CrudRepository<Examination,Integer> {

    List<Examination> findAllByClassSubject(ClassSubject classSubject);

}
