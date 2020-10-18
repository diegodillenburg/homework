/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unesp.rc.homework.model;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Turma(){
        super();
    }
    
    public Turma(Long id){
        super();
        this.id = id;
        this.nome = nome;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
