package com.example.solutions.repositories;

import com.example.solutions.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainerRepository extends JpaRepository<Trainer,Long> {
    List<Trainer> findByDepartment(String department);
    List<Trainer> findByTechnology(String technology);
}
