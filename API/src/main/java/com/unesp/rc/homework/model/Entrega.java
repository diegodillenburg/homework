package com.unesp.rc.homework.model;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "entregas")
public class Entrega {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String fileUrl;

    @ManyToOne
    private Atividade atividade;

    @ManyToOne
    private Aluno aluno;

    public Entrega() { super(); }

    public Entrega(Long id, String fileUrl, Atividade atividade, Aluno aluno) {
        super();
        this.id = id;
        this.fileUrl = fileUrl;
        this.atividade = atividade;
        this.aluno = aluno;
    }

    public Long getId() { return this.id; }

    public void setId(Long id) { this.id = id; }

    public String getFileUrl() { return this.fileUrl; }

    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }

//    public Aluno getAluno() { return this.aluno; }
//
//    public void setAluno(Optional<Aluno> aluno) { this.aluno = aluno; }
}
