/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.data.service;

import com.example.homework.data.entity.Atividade;
import com.example.homework.request.HttpRequestClass;
import com.example.homework.views.MainCardView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpResponse;

/**
 *
 * @author Spiga
 */
public class AtividadeService {

    private String token = MainCardView.token;
    
    public Atividade save(Atividade atividade){
        
        HttpRequestClass resquestClass = new HttpRequestClass();
        
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        
        try {
             json = mapper.writeValueAsString(atividade);
             System.out.println("ResultingJSONstring = " + json);
             //System.out.println(json);
         } catch (JsonProcessingException e) {
             e.printStackTrace();
         }
        HttpResponse retorno = resquestClass.request("POST", "atividades", json, token);
        
        if(retorno != null){
            try{
                atividade = mapper.readValue(retorno.body().toString(), Atividade.class);
                return atividade;
            }catch(JsonProcessingException ex){
                return null;
            }
        }
        return atividade;
    }
}
    
    