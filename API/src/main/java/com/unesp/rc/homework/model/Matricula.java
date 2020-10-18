/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unesp.rc.homework.model;

import javax.persistence.*;

/**
 *
 * @author Spiga
 */
@Entity
@Table(name = "matriculas")
public class Matricula {
    
    @Id
    @GeneratedValue
    private Long id;

    private Long aluno_id;

    private Long turma_id;
    
    public Matricula(){
    
    }
    
    public Matricula(Long id, Long aluno_id, Long turma_id){
        this.id = id;
        this.aluno_id = aluno_id;
        this.turma_id = turma_id;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getAlunoId() {
        return aluno_id;
    }

    public void setAlunoId(Long aluno_id) {
        this.aluno_id = aluno_id;
    }

    public Long getTurmaId() {
        return turma_id;
    }

    public void setTurmaId(Long turma_id) {
        this.turma_id = turma_id;
    }
    
}
