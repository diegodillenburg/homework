package com.unesp.rc.homework.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;
import javax.persistence.*;

@Entity
@JsonTypeName("Aluno")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
              include = JsonTypeInfo.As.PROPERTY,
              property = "type")
public class Aluno extends Usuario{
    
    private String periodo;
    
    private String instituicao;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="matriculas",
              joinColumns={@JoinColumn(name="aluno_id",
               referencedColumnName="id")},
              inverseJoinColumns={@JoinColumn(name="turma_id",
                referencedColumnName="id")})
    private List<Turma> turmas;
    
    public Aluno(){
    
    }
    
    public Aluno(Long id, String periodo, String instituicao, List<Turma> turmas, String nome, String senha, String login, String email, String telefone, String endereco) {
        super(id, nome, senha, login, email, telefone, endereco);
        this.periodo = periodo;
        this.instituicao = instituicao;
        this.turmas = turmas;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    
    
    
}
