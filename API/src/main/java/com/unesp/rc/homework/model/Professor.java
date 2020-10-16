/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unesp.rc.homework.model;

import java.util.List;

/**
 *
 * @author Felipe
 */
public class Professor extends Usuario{
    private String departamento;
    
    private Boolean efetivo;

    public Professor(String departamento, Boolean efetivo, Long id, String nome, String senha, String login, List email, List telefone, List endereco) {
        super(id, nome, senha, login, email, telefone, endereco);
        this.departamento = departamento;
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
