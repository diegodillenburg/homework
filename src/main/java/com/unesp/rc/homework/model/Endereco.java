/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unesp.rc.homework.model;

/**
 *
 * @author Felipe
 */
public class Endereco {
    private Boolean principal;
    
    private String enderecoCompleto;
    

    public Endereco(Boolean principal, String enderecoCompleto, String usuario) {
        this.principal = principal;
        this.enderecoCompleto = enderecoCompleto;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }


    
    
}
