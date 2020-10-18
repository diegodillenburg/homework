package com.unesp.rc.homework.controller;

import com.unesp.rc.homework.model.Turma;
import com.unesp.rc.homework.repository.TurmaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TurmaController {
    @Autowired
    TurmaRepository turmaRepository;
    
    @GetMapping("/turmas")
    public List<Turma> getAll() {
        return turmaRepository.findAll();
    }
    
    @PostMapping("/turma")
    public Turma create(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }
    
    @GetMapping("/turma/{id}")
    public Optional<Turma> getById(@PathVariable(value = "id") Long turmaId) {
        return turmaRepository.findById(turmaId);
    }
}
