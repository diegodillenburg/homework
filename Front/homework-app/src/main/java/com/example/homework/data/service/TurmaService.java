/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.data.service;

import com.example.homework.data.entity.Turma;
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
public class TurmaService {
    
    private String token = MainCardView.token;
    
    private ObjectMapper mapper = new ObjectMapper();
    
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

    public List<Turma> getAll() {
        List<Turma> turmas = new ArrayList<>();
        HttpRequestClass resquestClass = new HttpRequestClass();
        HttpResponse retorno = resquestClass.request("GET", "turmas", "", token);
        
        if(retorno != null){
            try{
                turmas = Arrays.asList(mapper.readValue(retorno.body().toString(), Turma[].class));
                return turmas;
            }catch(JsonProcessingException ex){
                return null;
            }
        }
        return turmas;
    }

    public List<Turma> getAllByAluno(long id_aluno) {
        List<Turma> turmas = new ArrayList<>();
        HttpRequestClass resquestClass = new HttpRequestClass();
        HttpResponse retorno = resquestClass.request("GET", "turmas?aluno_id="+id_aluno, "", token);
        
        if(retorno != null){
            try{
                turmas = Arrays.asList(mapper.readValue(retorno.body().toString(), Turma[].class));
                return turmas;
            }catch(JsonProcessingException ex){
                return null;
            }
        }
        return turmas;
    }
}
