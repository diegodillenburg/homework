/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unesp.rc.homework.model;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "turma")
public class Turma {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String nome;
    
    private Date data_inicio_inscricao;

    private Date data_fim_inscricao;
    
    private Date data_inicio_aulas;
    
    private Date data_fim_aulas;
    
    private double carga_total;
    
    private int max_alunos;
    
    public Turma(){
        super();
    }
    
    public Turma(Long id, String nome, Date data_inicio_inscricao, Date data_fim_inscricao, Date data_inicio_aulas, Date data_fim_aulas, double carga_total, int max_alunos){
        super();
        this.id = id;
        this.nome = nome;
        this.data_inicio_inscricao = data_inicio_inscricao;
        this.data_fim_inscricao = data_fim_inscricao;
        this.data_inicio_aulas = data_inicio_aulas;
        this.data_fim_aulas = data_fim_aulas;
        this.carga_total = carga_total;
        this.max_alunos = max_alunos;
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
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
