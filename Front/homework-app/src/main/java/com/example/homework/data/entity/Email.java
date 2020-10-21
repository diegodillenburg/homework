/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.data.entity;

import com.example.homework.data.AbstractEntity;
import javax.persistence.Entity;

@Entity
public class Email extends AbstractEntity{
    
    private String dominio;
    
    private Boolean principal;
    
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
