package com.example.goliathwelcomeapplication.service;

import com.example.goliathwelcomeapplication.dao.CrewRepository;
import com.example.goliathwelcomeapplication.entity.Crew;
import com.example.goliathwelcomeapplication.requestmodels.AddCrewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CrewService {

    private CrewRepository crewRepository;

    @Autowired
    public CrewService(CrewRepository crewRepository){
        this.crewRepository = crewRepository;
    }

    public void postCrew(AddCrewRequest addCrewRequest) {
        Crew crew = new Crew();
        crew.setRank(addCrewRequest.getRank());
        crew.setName(addCrewRequest.getName());
        crew.setDescription(addCrewRequest.getDescription());
        crew.setDepartment(addCrewRequest.getDepartment());
        crew.setImg(addCrewRequest.getImg());
        crewRepository.save(crew);
    }
}
