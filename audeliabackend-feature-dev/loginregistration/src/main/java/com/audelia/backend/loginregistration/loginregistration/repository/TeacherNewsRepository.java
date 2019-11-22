package com.audelia.backend.loginregistration.loginregistration.repository;

import com.audelia.backend.loginregistration.loginregistration.model.Admin;
import com.audelia.backend.loginregistration.loginregistration.model.TeacherNews;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface TeacherNewsRepository extends CrudRepository<TeacherNews,Integer> {

    List<TeacherNews> findAllByStatus(String status);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE teacher_news t SET t.status=:status , t.approved_by=:admin WHERE t.id=:id",nativeQuery = true)
    int updateStatus(@Param("status") String status, @Param("admin") Admin admin, @Param("id") int id);

}
