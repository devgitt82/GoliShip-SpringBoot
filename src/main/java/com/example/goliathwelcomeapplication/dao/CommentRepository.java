package com.example.goliathwelcomeapplication.dao;

import com.example.goliathwelcomeapplication.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findByCrewId(@RequestParam("crew_id") Long crewId, Pageable pageable);

    Comment findByUserEmailAndCrewId(String userEmail, Long crewId);

    @Modifying
    @Query("delete from Comment where crewId in :crew_id")
    void deleteAllByCrewId(@Param("crew_id") Long crewId);

}
