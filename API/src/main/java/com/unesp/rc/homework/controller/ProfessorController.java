package com.unesp.rc.homework.controller;

import com.unesp.rc.homework.model.Professor;
import com.unesp.rc.homework.repository.ProfessorRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProfessorController {
    @Autowired
    ProfessorRepository professorRepository;
    
    @GetMapping("/professores")
    public List<Professor> getAllProfessores() {
        return professorRepository.findAll();
    }
    
    @PostMapping("/professores")
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }
    
    @GetMapping("/professores/{id}")
    public Optional<Professor> getProfessorById(@PathVariable(value = "id") Long professorId) {
        return professorRepository.findById(professorId);
    }
}
