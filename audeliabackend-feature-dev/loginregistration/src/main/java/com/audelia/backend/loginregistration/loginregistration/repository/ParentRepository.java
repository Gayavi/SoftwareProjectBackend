package com.audelia.backend.loginregistration.loginregistration.repository;

import com.audelia.backend.loginregistration.loginregistration.model.Parent;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ParentRepository extends CrudRepository<Parent,String> {
    Parent findByRegistrationNumber(String registrationNumber);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE PARENT a SET a.password=:password WHERE a.registration_number=:registrationNumber",nativeQuery = true)
    void updateParentPassword(@Param("password")  String password, @Param("registrationNumber") String registrationNumber);

}
