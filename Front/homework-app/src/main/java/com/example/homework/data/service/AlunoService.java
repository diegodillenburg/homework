/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.data.service;

import com.example.homework.data.entity.Aluno;
import com.example.homework.request.HttpRequestClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpResponse;
/**
 *
 * @author Spiga
 */
public class AlunoService {
    
        public String token = "null";
    
    public HttpResponse saveAluno(Aluno aluno){
        
        
        HttpRequestClass resquestClass = new HttpRequestClass();
        
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        
        try {
             json = mapper.writeValueAsString(aluno);
             System.out.println("ResultingJSONstring = " + json);
             //System.out.println(json);
         } catch (JsonProcessingException e) {
             e.printStackTrace();
         }
        HttpResponse retorno = resquestClass.request("POST", "alunos", json, token );
             
        return retorno;
    }
    
}
