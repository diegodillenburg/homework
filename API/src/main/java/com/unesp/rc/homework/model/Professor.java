package com.unesp.rc.homework.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import javax.persistence.*;

@Entity
@JsonTypeName("Professor")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
              include = JsonTypeInfo.As.PROPERTY,
              property = "type")
public class Professor extends Usuario{

    private String departamento;
    
    private Boolean efetivo;
   
    public Professor(){
    
    }
    
    public Professor(String departamento, Boolean efetivo, Long id, String nome, String senha, String login, String email, String telefone, String endereco) {
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
