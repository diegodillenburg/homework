
package com.example.homework.data.service;

import com.example.homework.data.entity.Usuario;
import com.example.homework.request.HttpRequestClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Service
public class LoginService extends CrudService<Usuario, Integer> {

    private LoginRepository repository;

    public LoginService() {
        this.repository = repository;
    }

    @Override
    protected LoginRepository getRepository() {
        return repository;
    }   
    
    public ArrayList<JSONObject> getRequest(){
        HttpRequestClass resquestClass = new HttpRequestClass();
        return null;
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
        HttpResponse retorno = resquestClass.request("POST", "usuario/login", json);//aqui ta o erro
        
        //Gson gson = new Gson();
        
       
        return retorno;
    }

}
