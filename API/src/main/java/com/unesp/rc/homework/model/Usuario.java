/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unesp.rc.homework.model;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Felipe
 */

@Entity
@Inheritance
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;

    private String login;

    private String senha;
    
    private String telefone;
    
    private String email;
    
    private String endereco;    
    
    public Usuario(){
        super();
    }
    
    public Usuario(Long id, String nome, String senha, String login, String email, String telefone, String endereco) {
        super();
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    
}
