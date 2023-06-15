package com.example.goliathwelcomeapplication.controller;

import com.example.goliathwelcomeapplication.dao.CrewRepository;
import com.example.goliathwelcomeapplication.requestmodels.AddCrewRequest;
import com.example.goliathwelcomeapplication.service.CrewService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping(path="/api/crew/secure")
public class CrewController {

    private  CrewService crewService;

    @Autowired
    public CrewController(CrewService crewService){this.crewService = crewService;}

    @PostMapping("/add")
    public void postCrew(@RequestHeader(value="Authorization") String token,
                         @RequestBody AddCrewRequest addCrewRequest) throws Exception {

        //TODO
        //JWT extraction to be included here - if statement to be corrected
         if (1 == 0){
            throw new Exception("Admin access required");
        }
        crewService.postCrew(addCrewRequest);
    }

}
