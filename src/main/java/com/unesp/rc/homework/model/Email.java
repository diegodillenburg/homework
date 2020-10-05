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
public class Email {
    private String dominio;
    
    private Boolean principal;

    public Email(String dominio, Boolean principal) {
        this.dominio = dominio;
        this.principal = principal;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }
    
      
}
