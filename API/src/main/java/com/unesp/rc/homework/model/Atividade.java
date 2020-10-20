package com.unesp.rc.homework.model;

import javax.persistence.*;

@Entity
@Table(name = "atividades")
public class Atividade {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    private String tipoAtividade;

    public Atividade() {
        super();
    }
    
    public Atividade(Long id, String titulo, String descricao, String tipoAtividade) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipoAtividade = tipoAtividade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
