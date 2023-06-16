package com.example.goliathwelcomeapplication.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="user_email")
    private String userEmail;

    @CreationTimestamp
    @Column(name="date")
    private Date date;

    @Column(name="rating")
    private double rating;

    @Column(name="crew_id")
    private Long crewId;

    @Column(name="comment_description")
    private String commentDescription;
}
