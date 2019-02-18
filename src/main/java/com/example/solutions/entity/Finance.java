package com.example.solutions.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "EMPLOYEE_SALARY")
@Entity
@Data
public class Finance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pan_no;
    private String salary;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Trainer trainer;

}
