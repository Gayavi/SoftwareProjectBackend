package com.audelia.backend.loginregistration.loginregistration.repository;

import com.audelia.backend.loginregistration.loginregistration.model.Class;
import com.audelia.backend.loginregistration.loginregistration.model.ClassID;
import com.audelia.backend.loginregistration.loginregistration.model.ClassStudent;
import com.audelia.backend.loginregistration.loginregistration.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassStudentRepository extends CrudRepository<ClassStudent,Integer> {

    List<ClassStudent> findByAClass(Class aclass);
    List<ClassStudent> findAllByStudent(Student student);


}
