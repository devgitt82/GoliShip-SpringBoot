package com.example.goliathwelcomeapplication.dao;

import com.example.goliathwelcomeapplication.entity.Crew;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(collectionResourceRel = "crew", path = "crew")
public interface CrewRepository extends JpaRepository<Crew, Long> {

    Page<Crew> findByRankContaining(@RequestParam("rank") String rank, Pageable pageable);

    Page<Crew> findByDepartment(@RequestParam("department") String department, Pageable pageable);
}
