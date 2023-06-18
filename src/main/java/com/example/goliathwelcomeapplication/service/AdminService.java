package com.example.goliathwelcomeapplication.service;

import com.example.goliathwelcomeapplication.dao.CommentRepository;
import com.example.goliathwelcomeapplication.dao.CrewRepository;
import com.example.goliathwelcomeapplication.entity.Crew;
import com.example.goliathwelcomeapplication.requestmodels.AddCrewRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AdminService {

    private CrewRepository crewRepository;
    private CommentRepository commentRepository;


    @Autowired
    public AdminService (CrewRepository crewRepository,CommentRepository commentRepository){
        this.crewRepository = crewRepository;
        this.commentRepository = commentRepository;
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

    public void deleteCrew(Long crewId) throws Exception {

        Optional<Crew> crew = crewRepository.findById(crewId);

        if (!crew.isPresent()) {
            throw new Exception("Crew not found");
        }

        crewRepository.delete(crew.get());
        commentRepository.deleteAllByCrewId(crewId);
    }
}