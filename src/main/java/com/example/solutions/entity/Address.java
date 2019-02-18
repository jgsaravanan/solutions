package com.example.solutions.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String city;

    @Column(length = 250)
    private String streetName;

    @Column(length = 25)
    private String type;

    @ManyToOne
    @JsonIgnore
    private Student student;

}
