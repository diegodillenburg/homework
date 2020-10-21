package com.unesp.rc.homework.controller;

import com.unesp.rc.homework.model.Aluno;
import com.unesp.rc.homework.repository.AlunoRepository;
import com.unesp.rc.homework.repository.EntregaRepository;
import com.unesp.rc.homework.service.AmazonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

import com.unesp.rc.homework.model.Entrega;
import com.unesp.rc.homework.repository.EntregaRepository;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EntregaController {
    @Autowired
    EntregaRepository entregaRepository;

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    private AmazonClient amazonClient;

    @PostMapping("/entregas")
    public Entrega createEntrega(@RequestParam("file") MultipartFile file,
                                 @RequestParam("aluno_id") Long alunoId,
                                 @RequestParam("atividade_id") Long atividadeId) {
        // upload file to s3
        amazonClient.uploadFile(file);

        Entrega entrega = new Entrega();

//        entrega.setAluno(alunoRepository.findById(alunoId));

        return entrega;

    }
}
