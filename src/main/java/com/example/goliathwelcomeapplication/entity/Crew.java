package com.example.goliathwelcomeapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="crew")
public class Crew {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(name = "rank")
    private String rank;

    @Column(name = "name")
    private String name;

    @Column(name = "crew_description")
    private String description;

    @Column(name = "department")
    private String department;

    @Column(name = "img")
    private String img;
}
