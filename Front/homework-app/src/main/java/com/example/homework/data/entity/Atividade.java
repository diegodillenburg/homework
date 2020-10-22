/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.data.entity;

import com.example.homework.data.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;
import javax.persistence.*;

@Entity
public class Atividade extends AbstractEntity{

    private Long turma_id;

    private String titulo;

    private String descricao;

    private String tipoAtividade;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="atividade_id")
    private List<Comentario> comentarios;

    public Long getTurmaId() { return turma_id; }

    public void setTurmaId(Long turma_id) { this.turma_id = turma_id; }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(String tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) { this.comentarios = comentarios; }
}
