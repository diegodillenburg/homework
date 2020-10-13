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
@Table(name = "emails")
public class Email {
    @Id
    @GeneratedValue
    private Long id;
    
    private String dominio;
    
    private Boolean principal;
    
    public Email() {
        super();
    }

    public Email(Long id, String dominio, Boolean principal) {
        super();
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrincipal(Boolean principal) {
        this.principal = principal;
    }
    
      
}
