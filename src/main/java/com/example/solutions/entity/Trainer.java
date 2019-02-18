package com.example.solutions.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TRAINER")
@Data
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    private String technology;

    private String department;

    @ManyToMany(mappedBy = "trainers")
    @JsonIgnore
    private List<Student> students;

    @OneToOne(mappedBy = "trainer")
    @JsonIgnore
    private Finance finance;

}
