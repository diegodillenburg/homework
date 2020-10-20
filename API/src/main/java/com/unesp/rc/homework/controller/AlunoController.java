package com.unesp.rc.homework.controller;

import com.unesp.rc.homework.model.Aluno;
import com.unesp.rc.homework.model.Turma;
import com.unesp.rc.homework.repository.AlunoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlunoController {
    @Autowired
    AlunoRepository alunoRepository;
    
    @GetMapping("/alunos")
    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }
    
    @PostMapping("/alunos")
    public Aluno createAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    
    @GetMapping("/alunos/{id}")
    public Optional<Aluno> getAlunoById(@PathVariable(value = "id") Long alunoId) {        
        return alunoRepository.findById(alunoId);
    }
    
}
