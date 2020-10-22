package com.unesp.rc.homework.model;

import javax.persistence.*;

@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String texto;

    private Long atividade_id;

    @ManyToOne
    private Usuario usuario;

    public Comentario() { super(); }

    public Comentario(Long id, String texto, Long atividade_id, Usuario usuario) {
        super();
        this.id = id;
        this.texto = texto;
        this.atividade_id = atividade_id;
        this.usuario = usuario;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getAtividadeId() { return atividade_id; }

    public void setAtividadeId(Long atividade_id) { this.atividade_id = atividade_id; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getTexto() { return texto; }

    public void setTexto(String texto) { this.texto = texto; }
}
