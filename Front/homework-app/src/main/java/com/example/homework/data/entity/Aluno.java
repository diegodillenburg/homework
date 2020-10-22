/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.data.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;
import javax.persistence.*;

@Entity
@JsonTypeName("Aluno")
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
