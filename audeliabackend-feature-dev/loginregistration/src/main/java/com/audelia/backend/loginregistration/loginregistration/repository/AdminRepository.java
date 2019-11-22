package com.audelia.backend.loginregistration.loginregistration.repository;

import com.audelia.backend.loginregistration.loginregistration.model.Admin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface AdminRepository extends CrudRepository<Admin,String> {
    Admin findByRegistrationNumber(String registrationNumber);


    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE ADMIN a SET a.password=:password WHERE a.registration_number=:registrationNumber",nativeQuery = true)
    void updateAdminPassword(@Param("password")  String password,@Param("registrationNumber") String registrationNumber);

}
