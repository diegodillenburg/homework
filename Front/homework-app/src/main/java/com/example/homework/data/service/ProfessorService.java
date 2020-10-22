/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.data.service;

import com.example.homework.data.entity.Professor;
import com.example.homework.request.HttpRequestClass;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpResponse;

/**
 *
 * @author Spiga
 */
public class ProfessorService {
    
    public HttpResponse saveProfessor(Professor professor){
        
        HttpRequestClass resquestClass = new HttpRequestClass();
        
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        
        try {
             json = mapper.writeValueAsString(professor);
             System.out.println("ResultingJSONstring = " + json);
             //System.out.println(json);
         } catch (JsonProcessingException e) {
             e.printStackTrace();
         }
        HttpResponse retorno = resquestClass.request("POST", "professores", json);
             
        return retorno;
    }
    
}
