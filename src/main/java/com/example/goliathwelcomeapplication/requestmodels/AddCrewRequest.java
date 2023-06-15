package com.example.goliathwelcomeapplication.requestmodels;

import lombok.Data;

@Data
public class AddCrewRequest {

    private String rank;

    private String name;

    private String description;

    private String department;

    private String img;

}