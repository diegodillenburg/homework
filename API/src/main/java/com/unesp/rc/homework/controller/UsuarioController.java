package com.unesp.rc.homework.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.unesp.rc.homework.model.Aluno;
import com.unesp.rc.homework.model.Professor;
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
    
    @PostMapping("/usuarios/login")
    public Usuario authenticate(@RequestBody Usuario usuario) throws JsonProcessingException {
        Usuario user = usuarioRepository.authenticate(usuario.getLogin(),usuario.getSenha());
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerSubtypes(new NamedType(Aluno.class, "Aluno"));
        mapper.registerSubtypes(new NamedType(Professor.class, "Professor"));
        String json = mapper.writeValueAsString(user);
        user = mapper.readValue(json, Usuario.class);
        return user;
    }
}
