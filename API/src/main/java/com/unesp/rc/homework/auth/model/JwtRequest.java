package com.unesp.rc.homework.auth.model;

import java.io.Serializable;

public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String login;
    private String senha;

    public JwtRequest()
    {
    }

    public JwtRequest(String username, String password) {
        this.setLogin(username);
        this.setSenha(password);
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}