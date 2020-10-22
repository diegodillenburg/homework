/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.data.service;

import com.example.homework.data.entity.Aluno;
import com.example.homework.request.HttpRequestClass;
import com.example.homework.views.MainCardView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author Spiga
 */
public class AlunoService {
    
    private ObjectMapper mapper = new ObjectMapper();

    private String token = MainCardView.token;
    
    public HttpResponse saveAluno(Aluno aluno){
        
        HttpRequestClass resquestClass = new HttpRequestClass();
        
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        
        try {
             json = mapper.writeValueAsString(aluno);
             System.out.println("ResultingJSONstring = " + json);
         } catch (JsonProcessingException e) {
             e.printStackTrace();
         }
        HttpResponse retorno = resquestClass.request("POST", "alunos", json, token );
             
        return retorno;
    }

    public List<Aluno> getAll() {
        List<Aluno> alunos = new ArrayList<>();
        HttpRequestClass resquestClass = new HttpRequestClass();
        HttpResponse retorno = resquestClass.request("GET", "alunos", "", token);
        
        if(retorno != null){
            try{
                alunos = Arrays.asList(mapper.readValue(retorno.body().toString(), Aluno[].class));
                return alunos;
            }catch(JsonProcessingException ex){
                return null;
            }
        }
        return alunos;
    }
    
}
