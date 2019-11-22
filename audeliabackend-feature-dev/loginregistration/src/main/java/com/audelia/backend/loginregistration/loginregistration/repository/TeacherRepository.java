package com.audelia.backend.loginregistration.loginregistration.repository;

import com.audelia.backend.loginregistration.loginregistration.model.Teacher;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TeacherRepository extends CrudRepository<Teacher,String> {
    Teacher findByRegistrationNumber(String registrationNumber);

    List<Teacher> findAll();

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE TEACHER a SET a.password=:password WHERE a.registration_number=:registrationNumber",nativeQuery = true)
    void updateTeacherPassword(@Param("password")  String password, @Param("registrationNumber") String registrationNumber);

}
