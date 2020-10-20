package com.unesp.rc.homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

import com.unesp.rc.homework.model.Atividade;
import com.unesp.rc.homework.repository.AtividadeRepository;
import com.unesp.rc.homework.exception.AtividadeNotFoundException;

@RestController
public class AtividadeController {
    @Autowired
    AtividadeRepository atividadeRepository;

    @GetMapping("/atividades")
    public List<Atividade> getAllAtividade(@RequestParam(name = "turma_id") Long turma_id) {
        return atividadeRepository.findByTurmaId(turma_id);
    }

    @PostMapping("/atividades")
    public Atividade createAtividade(@RequestBody Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    @GetMapping("/atividades/{id}")
    public Atividade getAtividadeById(@PathVariable(value = "id") Long atividadeId) throws AtividadeNotFoundException {
        return atividadeRepository.findById(atividadeId)
                .orElseThrow(() -> new AtividadeNotFoundException(atividadeId));
    }

    @PutMapping("/atividades/{id}")
    public Atividade updateAtividade(@PathVariable(value = "id") Long atividadeId,
                                       @RequestBody Atividade atividadeDetails) throws AtividadeNotFoundException {
        Atividade atividade = atividadeRepository.findById(atividadeId)
                .orElseThrow(() -> new AtividadeNotFoundException(atividadeId));

        atividade.setTitulo(atividadeDetails.getTitulo());
        atividade.setDescricao(atividadeDetails.getDescricao());
        atividade.setTipoAtividade(atividadeDetails.getTipoAtividade());

        Atividade updatedAtividade = atividadeRepository.save(atividade);

        return updatedAtividade;
    }

    @DeleteMapping("/atividades/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value  = "id") Long atividadeId) throws AtividadeNotFoundException {
        Atividade atividade = atividadeRepository.findById(atividadeId)
                .orElseThrow(() -> new AtividadeNotFoundException(atividadeId));

        atividadeRepository.delete(atividade);

        return ResponseEntity.ok().build();
    }
}
