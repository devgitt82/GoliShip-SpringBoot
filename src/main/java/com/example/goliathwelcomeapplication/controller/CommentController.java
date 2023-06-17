package com.example.goliathwelcomeapplication.controller;

import com.example.goliathwelcomeapplication.requestmodels.CommentRequest;
import com.example.goliathwelcomeapplication.service.CommentService;
import com.example.goliathwelcomeapplication.utils.JWTextractor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/comments")

public class CommentController {

    private CommentService commentService;

    public CommentController (CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/secure/user/crew")
    public Boolean reviewCrewByUser(@RequestHeader(value="Authorization") String token,
                                    @RequestParam Long crewId) throws Exception {

        String userEmail = JWTextractor.payloadJWTExtraction(token, "\"sub\"");
        if (userEmail == null) {
            throw new Exception("User email is missing");
        }
        return commentService.userCommentListed(userEmail, crewId);
    }

    @PostMapping("/secure")
    public void postReview(@RequestHeader(value="Authorization") String token,
                           @RequestBody CommentRequest commentRequest) throws Exception {

        String userEmail =  JWTextractor.payloadJWTExtraction(token, "\"sub\"");
        if (userEmail == null) {
            throw new Exception("User email is missing");
        }
        commentService.postComment(userEmail, commentRequest);
    }
}
