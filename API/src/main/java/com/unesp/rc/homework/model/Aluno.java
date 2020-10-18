/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unesp.rc.homework.model;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Felipe
 */
@Entity
public class Aluno extends Usuario{
    
    private String periodo;
    
    private String instituicao;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="usuario_turma",
              joinColumns={@JoinColumn(name="usuario_id",
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
