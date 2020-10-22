/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.data.service;

import com.example.homework.data.entity.Comentario;
import com.example.homework.request.HttpRequestClass;
import com.example.homework.views.MainCardView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpResponse;
import java.util.Optional;

/**
 *
 * @author Spiga
 */
public class ComentarioService {
    private String token = MainCardView.token;
    
    public Comentario save(Comentario comment){
        
        HttpRequestClass resquestClass = new HttpRequestClass();
        
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        
        try {
             json = mapper.writeValueAsString(comment);
             System.out.println("ResultingJSONstring = " + json);
             //System.out.println(json);
         } catch (JsonProcessingException e) {
             e.printStackTrace();
         }
        HttpResponse retorno = resquestClass.request("POST", "comentarios", json, token);
        
        if(retorno != null){
            try{
                comment = mapper.readValue(retorno.body().toString(), Comentario.class);
                return comment;
            }catch(JsonProcessingException ex){
                return null;
            }
        }
        return comment;
    }
}
