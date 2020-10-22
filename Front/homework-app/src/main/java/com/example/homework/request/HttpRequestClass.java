/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.request;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author Spiga
 */
public class HttpRequestClass {
    
    private String apiHost = "http://localhost:8080/";
    
    public static String authorization = "";
    
    public HttpResponse request(String method, String path, String body, String token){
        switch (method){
            case "GET":
                return getMethod(path, token);
            case "POST":
                return postMethod(path, body, token);
            default:
                return null;
        }
    }
    
    private HttpResponse getMethod(String path, String token){
        HttpResponse response = null;
        try{
            HttpClient client = HttpClient.newHttpClient();
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiHost + path))
                    .header("Authorization", "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJmZWxpcGUiLCJleHAiOjE2MDMzNDY5MjYsImlhdCI6MTYwMzMyODkyNn0.aywk6JTk_GE9mS14qPbWdHOimyG1JqAQGMc9kU1AhqMtqfFeWjiNGDxvg7n9R4mhEws3889eSJy9ZDIg0XQa3A")
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
            
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            return response;
        }
        catch(Exception e){
            return null;
        }
    }
    
    private HttpResponse postMethod(String path, String body, String token){
        try{
            
            HttpClient client = HttpClient.newHttpClient();
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiHost + path))
                    .header("Content-Type", "application/json")
                    .header("Authorization", token)
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