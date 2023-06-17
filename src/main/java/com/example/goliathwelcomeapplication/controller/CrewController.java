package com.example.goliathwelcomeapplication.controller;

import com.example.goliathwelcomeapplication.dao.CrewRepository;
import com.example.goliathwelcomeapplication.requestmodels.AddCrewRequest;
import com.example.goliathwelcomeapplication.service.CrewService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Data
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(path="/api/crew/secure")
public class CrewController {

    private  CrewService crewService;

    @Autowired
    public CrewController(CrewService crewService){this.crewService = crewService;}



}
