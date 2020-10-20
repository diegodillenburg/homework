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
    public List<Turma> getAll(@RequestParam(required = false, value = "professor_id") Long professorId,
                              @RequestParam(required = false, value = "aluno_id") Long alunoId) {
        if (professorId != null) {
            return turmaRepository.findTurmasByProfessorId(professorId);
        } else if (alunoId != null) {
            return turmaRepository.findTurmasByAlunoId(alunoId);
        } else {
            return turmaRepository.findAll();
        }
    }

    @GetMapping("/turmas/disponiveis")
    public List<Turma> getTurmasDisponiveis() {
        return turmaRepository.findTurmasDisponiveis();
    }
    
    @PostMapping("/turmas")
    public Turma create(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }
    
    @GetMapping("/turmas/{id}")
    public Optional<Turma> getById(@PathVariable(value = "id") Long turmaId) {
        return turmaRepository.findById(turmaId);
    }
}
