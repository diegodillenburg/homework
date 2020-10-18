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
public class Professor extends Usuario{
    private String departamento;
    
    private Boolean efetivo;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="professor_turma",
              joinColumns={@JoinColumn(name="professor_id",
               referencedColumnName="id")},
              inverseJoinColumns={@JoinColumn(name="turma_id",
                referencedColumnName="id")})
    private List<Turma> turmas;

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
    
    public Professor(){
    
    }
    
    public Professor(String departamento, Boolean efetivo, Long id, List<Turma> turmas, String nome, String senha, String login, String email, String telefone, String endereco) {
        super(id, nome, senha, login, email, telefone, endereco);
        this.departamento = departamento;
        this.turmas = turmas;
        this.efetivo = efetivo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Boolean getEfetivo() {
        return efetivo;
    }

    public void setEfetivo(Boolean efetivo) {
        this.efetivo = efetivo;
    }
    
    
}
