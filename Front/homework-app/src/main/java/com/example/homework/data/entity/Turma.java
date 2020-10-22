/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.data.entity;

import com.example.homework.data.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Turma extends AbstractEntity{
    
    private String nome;
    
    @ManyToOne
    private Professor professor;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="turma_id")
    private List<Atividade> atividades;

    private Date data_inicio_inscricao;

    private Date data_fim_inscricao;
    
    private Date data_inicio_aulas;
    
    private Date data_fim_aulas;
    
    private double carga_total;
    
    private int max_alunos;
    
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
    
    public Date getData_inicio_inscricao() {
        return data_inicio_inscricao;
    }

    public void setData_inicio_inscricao(Date data_inicio_inscricao) {
        this.data_inicio_inscricao = data_inicio_inscricao;
    }

    public Date getData_fim_inscricao() {
        return data_fim_inscricao;
    }

    public void setData_fim_inscricao(Date data_fim_inscricao) {
        this.data_fim_inscricao = data_fim_inscricao;
    }

    public int getMax_alunos() {
        return max_alunos;
    }

    public void setMax_alunos(int max_alunos) {
        this.max_alunos = max_alunos;
    }

    public Date getData_inicio_aulas() {
        return data_inicio_aulas;
    }

    public void setData_inicio_aulas(Date data_inicio_aulas) {
        this.data_inicio_aulas = data_inicio_aulas;
    }

    public Date getData_fim_aulas() {
        return data_fim_aulas;
    }

    public void setData_fim_aulas(Date data_fim_aulas) {
        this.data_fim_aulas = data_fim_aulas;
    }

    public double getCarga_total() {
        return carga_total;
    }

    public void setCarga_total(double carga_total) {
        this.carga_total = carga_total;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
