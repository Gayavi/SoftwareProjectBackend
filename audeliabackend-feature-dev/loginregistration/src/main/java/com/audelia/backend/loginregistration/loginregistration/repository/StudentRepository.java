package com.audelia.backend.loginregistration.loginregistration.repository;

import com.audelia.backend.loginregistration.loginregistration.model.Parent;
import com.audelia.backend.loginregistration.loginregistration.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student,String> {
    Student findByRegistrationNumber(String registrationNumber);

    List<Student> findAllByParent(Parent parent);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE STUDENT a SET a.password=:password WHERE a.registration_number=:registrationNumber",nativeQuery = true)
    void updateStudentPassword(@Param("password")  String password, @Param("registrationNumber") String registrationNumber);



}
