package com.unesp.rc.homework.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "atividades")
public class Atividade {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Long turma_id;

    private String titulo;

    private String descricao;

    private String tipoAtividade;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="atividade_id")
    private List<Comentario> comentarios;

    public Atividade() {
        super();
    }
    
    public Atividade(Long id, Long turma_id, String titulo, String descricao, String tipoAtividade, List<Comentario> comentarios) {
        super();
        this.id = id;
        this.turma_id = turma_id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipoAtividade = tipoAtividade;
        this.comentarios = comentarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
