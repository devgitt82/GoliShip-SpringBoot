package com.example.goliathwelcomeapplication.requestmodels;

import lombok.Data;
import java.util.Optional;

@Data
public class CommentRequest {

    private double rating;

    private Long crewId;

    private Optional<String> CommentDescription;
}
