/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.data.service;

import com.example.homework.data.entity.Turma;
import com.example.homework.request.HttpRequestClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpResponse;

/**
 *
 * @author Spiga
 */
public class TurmaService {
    public String token = "null";
    
    public HttpResponse save(Turma turma){
        
        HttpRequestClass resquestClass = new HttpRequestClass();
        
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        
        try {
             json = mapper.writeValueAsString(turma);
             System.out.println("ResultingJSONstring = " + json);
             //System.out.println(json);
         } catch (JsonProcessingException e) {
             e.printStackTrace();
         }
        HttpResponse retorno = resquestClass.request("POST", "turmas", json, token);
             
        return retorno;
    }
}
