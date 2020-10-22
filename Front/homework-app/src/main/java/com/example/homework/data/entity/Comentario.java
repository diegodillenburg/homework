package com.example.homework.data.entity;

import com.example.homework.data.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
public class Comentario{
    
    @Id
    private Long id;

    private String texto;

    private Long atividade_id;

    @ManyToOne
    private Usuario usuario;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getAtividade_id() { return atividade_id; }

    public void setAtividade_id(Long atividade_id) { this.atividade_id = atividade_id; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getTexto() { return texto; }

    public void setTexto(String texto) { this.texto = texto; }
}
