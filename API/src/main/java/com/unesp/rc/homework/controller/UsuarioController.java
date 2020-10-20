package com.unesp.rc.homework.controller;

import com.unesp.rc.homework.model.Usuario;
import com.unesp.rc.homework.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    @GetMapping("/usuarios")
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }
    
    @GetMapping("/usuarios/{id}")
    public Optional<Usuario> getById(@PathVariable(value = "id") Long usuarioId) {
        return usuarioRepository.findById(usuarioId);
    }
}
