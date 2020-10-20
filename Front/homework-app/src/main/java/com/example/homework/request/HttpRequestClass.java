/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Spiga
 */
public class HttpRequestClass {
    
    private String apiHost = "http://localhost:8080/";
    
    public HttpResponse request(String method, String path, String body){
        switch (method){
            case "GET":
                return getMethod(path);
            case "POST":
                return postMethod(path, body);
            default:
                return null;
        }
    }
    
    private HttpResponse getMethod(String path){
        HttpResponse response = null;
        try{
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet(apiHost + path);
            Gson gson = new Gson();
            response = (HttpResponse) httpClient.execute(get);

            return response;
        }
        catch(Exception e){
            return null;
        }
    }
    
    private HttpResponse postMethod(String path, String body){
        try{
            
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper
                    .writeValueAsString(body);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiHost + path))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            return response;
        }
        catch(Exception e){
            return null;
        }
    }
    
}