package com.example.goliathwelcomeapplication.dao;

import com.example.goliathwelcomeapplication.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Page<Comment> findByCrewId(@RequestParam("crew_id") Long crewId, Pageable pageable);

    Comment findByUserEmailAndCrewId(String userEmail, Long crewId);

}
