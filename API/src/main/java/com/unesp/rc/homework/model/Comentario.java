package com.unesp.rc.homework.model;

import javax.persistence.*;

@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String texto;

    @ManyToOne
    private Atividade atividade;

    @ManyToOne
    private Usuario usuario;

    public Comentario() { super(); }

    public Comentario(Long id, String texto, Atividade atividade, Usuario usuario) {
        super();
        this.id = id;
        this.texto = texto;
        this.atividade = atividade;
        this.usuario = usuario;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Atividade getAtividade() { return atividade; }

    public void setAtividade(Atividade atividade) { this.atividade = atividade; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getTexto() { return texto; }

    public void setTexto(String texto) { this.texto = texto; }
}
