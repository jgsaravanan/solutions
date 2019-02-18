package com.example.solutions.controller;

import com.example.solutions.entity.Address;
import com.example.solutions.entity.Finance;
import com.example.solutions.entity.Student;
import com.example.solutions.entity.Trainer;
import com.example.solutions.repositories.AddressRepository;
import com.example.solutions.repositories.FinanceRepository;
import com.example.solutions.repositories.StudentRepository;
import com.example.solutions.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class DataController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private FinanceRepository financeRepository;

    @GetMapping("getAllStudents")
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @PostMapping("createStudents")
    public String createStudents(@RequestBody List<Student> studentList) {
        studentList.stream().forEach(s -> {
            List<Trainer> trainers = trainerRepository.findByDepartment(s.getDepartment());
            s.setTrainers(trainers);
        });
        List<Student> students = studentRepository.saveAll(studentList);
        students.stream().forEach(s -> {
            s.getAddressList().stream().forEach(a -> a.setStudent(s));
            addressRepository.saveAll(s.getAddressList());
        });
        return students.size() == 0 ? "Failed" : "Success";
    }

    @GetMapping("getStudentAddress/{id}")
    public List<Address> getStudentAddress(@PathVariable(name = "id") Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.isPresent() ? student.get().getAddressList() : Collections.emptyList();
    }

    @PostMapping("createTrainers")
    public String createTrainers(@RequestBody List<Finance> finances) {
        List<Finance> financeList = financeRepository.saveAll(finances);
        return financeList.size() == 0 ? "Failed" : "Success";
    }

    @GetMapping("findStudentsByTechnology/{technology}")
    public List<Student> findStudentsByTechnology(@PathVariable(name = "technology") String technology) {
        return trainerRepository.findByTechnology(technology).stream().flatMap(a->a.getStudents().stream()).collect(Collectors.toList());
    }

}
