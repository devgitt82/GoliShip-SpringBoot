package com.example.goliathwelcomeapplication.service;

import com.example.goliathwelcomeapplication.dao.CommentRepository;
import com.example.goliathwelcomeapplication.entity.Comment;
import com.example.goliathwelcomeapplication.requestmodels.CommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Date;
import java.time.LocalDate;

@Service
@Transactional

public class CommentService {


    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void postComment(String userEmail, CommentRequest commentRequest) throws Exception {

        Comment validateComment = commentRepository.findByUserEmailAndCrewId(userEmail, commentRequest.getCrewId());
        if (validateComment != null) {
            throw new Exception(" invalid comment");
        }

        Comment comment = new Comment();
        comment.setCrewId(commentRequest.getCrewId());
        comment.setRating(commentRequest.getRating());
        comment.setUserEmail(userEmail);
        if (commentRequest.getCommentDescription().isPresent()) {
            comment.setCommentDescription(commentRequest.getCommentDescription().map(
                    Object::toString
            ).orElse(null));
        }
        comment.setDate(Date.valueOf(LocalDate.now()));
        commentRepository.save(comment);
    }

    public Boolean userCommentListed(String userEmail, Long crewId) {
        Comment validateComment = commentRepository.findByUserEmailAndCrewId(userEmail, crewId);
        if (validateComment != null) {
            return true;
        } else {
            return false;
        }
    }
}









