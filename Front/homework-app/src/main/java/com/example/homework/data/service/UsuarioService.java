
package com.example.homework.data.service;

import com.example.homework.data.entity.Usuario;
import com.example.homework.request.HttpRequestClass;
import com.example.homework.views.MainCardView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    
    private String token = MainCardView.token;
        
    public HttpResponse autenticar(String login, String senha){
        
        HttpRequestClass requestClass = new HttpRequestClass();
        
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
        
        HttpResponse retorno = requestClass.request("POST", "authenticate", json, "null");
        
        MainCardView.token = tokenSplit((String) retorno.body());
        
        HttpResponse retorno2 = requestClass.request("POST", "usuarios/login", json, MainCardView.token);
       
        return retorno2;
    }
    
    public String tokenSplit(String token){
        token = token.substring(10);
        String [] novo = token.split("\"");
        token = "Bearer " + novo[0];
        
        return token;
    }
    
    public Usuario getUserByComment(Long id){
        
        Usuario user = new Usuario();
        
        HttpRequestClass requestClass = new HttpRequestClass();
        HttpResponse retorno = requestClass.request("GET", "comentarios/" + id, "", token);
        
        ObjectMapper mapper = new ObjectMapper();
        if(retorno != null){
            try{
                user = mapper.readValue(retorno.body().toString(), Usuario.class);
                return user;
            }catch(JsonProcessingException ex){
                return null;
            }
        }       
        
        return user;
    }
}
