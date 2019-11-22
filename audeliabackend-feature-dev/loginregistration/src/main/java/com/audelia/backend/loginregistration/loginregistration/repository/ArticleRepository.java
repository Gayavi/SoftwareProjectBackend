package com.audelia.backend.loginregistration.loginregistration.repository;

import com.audelia.backend.loginregistration.loginregistration.model.Articles;
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
public interface ArticleRepository extends CrudRepository<Articles,Integer> {

    List<Articles> findByStatus(String status);


    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE article a SET a.status=:status , a.teacher=:regNo WHERE a.id=:id",nativeQuery = true)
    int updateArticleStatus(@Param("status") String  status,@Param("regNo") Teacher regNo, @Param("id") int id);
}
