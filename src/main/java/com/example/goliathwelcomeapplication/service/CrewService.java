package com.example.goliathwelcomeapplication.service;

import com.example.goliathwelcomeapplication.dao.CrewRepository;
import com.example.goliathwelcomeapplication.entity.Crew;
import com.example.goliathwelcomeapplication.requestmodels.AddCrewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrewService {

    private CrewRepository crewRepository;

    @Autowired
    public CrewService(CrewRepository crewRepository){
        this.crewRepository = crewRepository;
    }

}
