package com.unesp.rc.homework.controller;

import com.unesp.rc.homework.model.Comentario;
import com.unesp.rc.homework.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComentarioController {
    @Autowired
    ComentarioRepository comentarioRepository;

    @GetMapping("/comentarios")
    public List<Comentario> getAllComentarios(@RequestParam(name = "atividade_id") Long atividade_id) {
        return comentarioRepository.findByAtividadeId(atividade_id);
    }

    @PostMapping("/comentarios")
    public Comentario createComentario(@RequestBody Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

}
