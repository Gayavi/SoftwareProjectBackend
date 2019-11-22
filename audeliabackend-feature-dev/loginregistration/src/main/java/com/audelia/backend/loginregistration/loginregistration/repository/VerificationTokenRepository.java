package com.audelia.backend.loginregistration.loginregistration.repository;

import com.audelia.backend.loginregistration.loginregistration.model.VerificationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface VerificationTokenRepository extends CrudRepository<VerificationToken,Integer> {

    VerificationToken findByUsername(String regNo);

    void deleteByUsername(String regNo);

}
