package com.example.goliathwelcomeapplication.dao;

import com.example.goliathwelcomeapplication.entity.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "crew", path = "crew")
public interface CrewRepository extends JpaRepository<Crew, Long> {
}
