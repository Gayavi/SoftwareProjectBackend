package com.audelia.backend.loginregistration.loginregistration.repository;

import com.audelia.backend.loginregistration.loginregistration.model.Class;
import com.audelia.backend.loginregistration.loginregistration.model.ClassSubject;
import com.audelia.backend.loginregistration.loginregistration.model.Subject;
import com.audelia.backend.loginregistration.loginregistration.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassSubjectRepository extends CrudRepository<ClassSubject, Integer> {

    List<ClassSubject> findAllByAClass(Class aclass);

    boolean existsByAClassAndSubject(Class aclass, Subject subject);

    List<ClassSubject> findAllByTeacher(Teacher teacher);

    List<ClassSubject> findAllByTeacherAndAClass(Teacher teacher,Class aclass);

    ClassSubject findByAClassAndSubject(Class aclass,Subject subject);

}
