package com.example.homework.data.entity;

import com.example.homework.data.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;

@Entity
public class Comentario extends AbstractEntity{

    private String texto;

    @ManyToOne
    @JsonManagedReference
    private Atividade atividade;

    @ManyToOne
    @JsonManagedReference
    private Usuario usuario;

    public Atividade getAtividade() { return atividade; }

    public void setAtividade(Atividade atividade) { this.atividade = atividade; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getTexto() { return texto; }

    public void setTexto(String texto) { this.texto = texto; }
}
