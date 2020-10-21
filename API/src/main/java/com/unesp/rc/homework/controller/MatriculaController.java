package com.unesp.rc.homework.controller;

import com.unesp.rc.homework.model.Matricula;
import com.unesp.rc.homework.repository.MatriculaRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MatriculaController {
    @Autowired
    MatriculaRepository matriculaRepository;
    
    @GetMapping("/matriculas/{aluno_id}")
    public List<Matricula> getAllByAlunoId(@PathVariable(name = "aluno_id") Long aluno_id) {
        return matriculaRepository.findByAlunoId(aluno_id);
    }
    
    @PostMapping("/matriculas")
    public Matricula create(@RequestBody Matricula matricula) {
        return matriculaRepository.save(matricula);
    }
}
