package com.example.goliathwelcomeapplication.dao;

import com.example.goliathwelcomeapplication.entity.Crew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewRepository extends JpaRepository<Crew, Long> {
}
