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
public class Telefone {
    private String numero;
    private Boolean principal;
    
    public Telefone (String numero, Boolean principal) {
        this.numero = numero;
        this.principal = principal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }
    
    
}
