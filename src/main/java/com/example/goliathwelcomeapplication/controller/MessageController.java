package com.example.goliathwelcomeapplication.controller;

import com.example.goliathwelcomeapplication.entity.Message;
import com.example.goliathwelcomeapplication.service.MessageService;
import com.example.goliathwelcomeapplication.utils.JWTextractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private MessageService messagesService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messagesService = messageService;
    }

    @PostMapping("/secure/add/message")
    public void postMessage(@RequestHeader(value="Authorization") String token,
                            @RequestBody Message messageRequest) {
        String userEmail = JWTextractor.payloadJWTExtraction(token, "\"sub\"");
        messagesService.postMessage(messageRequest, userEmail);
    }

}