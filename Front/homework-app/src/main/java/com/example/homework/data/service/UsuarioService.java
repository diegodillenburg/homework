
package com.example.homework.data.service;

import com.example.homework.data.entity.Usuario;
import com.example.homework.request.HttpRequestClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;


@Service
public class UsuarioService extends CrudService<Usuario, Integer> {

    private UsuarioRepository repository;
    
    public String token = "null";

    public UsuarioService() {
        this.repository = repository;
    }

    @Override
    protected UsuarioRepository getRepository() {
        return repository;
    }   
        
    public HttpResponse autenticar(String login, String senha){
        
        HttpRequestClass resquestClass = new HttpRequestClass();
        
        Usuario user = new Usuario();
        user.setLogin(login);
        user.setSenha(senha);
        
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        
        try {
             json = mapper.writeValueAsString(user);
             System.out.println("ResultingJSONstring = " + json);
             //System.out.println(json);
         } catch (JsonProcessingException e) {
             e.printStackTrace();
         }
        HttpResponse retorno = resquestClass.request("POST", "authenticate", json, token);
        
        token = tokenSplit((String) retorno.body());
        
        HttpResponse retorno2 = resquestClass.request("POST", "usuarios/login", json, token);
       
       
       
        return retorno2;
    }
    
    public String tokenSplit(String token){
        token = token.substring(10);
        String [] novo = token.split("\"");
        token = "Bearer " + novo[0];
        
        return token;
    }

}
