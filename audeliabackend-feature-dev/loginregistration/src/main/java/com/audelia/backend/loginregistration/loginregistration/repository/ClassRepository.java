package com.audelia.backend.loginregistration.loginregistration.repository;

import com.audelia.backend.loginregistration.loginregistration.model.Class;
import com.audelia.backend.loginregistration.loginregistration.model.ClassID;
import com.audelia.backend.loginregistration.loginregistration.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends CrudRepository<Class, ClassID> {

    Class findByClassID(ClassID classID);

    List<Class> findByTeacher (Teacher teacher);
}
