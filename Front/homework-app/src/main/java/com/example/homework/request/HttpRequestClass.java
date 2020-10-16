/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.request;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Spiga
 */
public class HttpRequestClass {
    
    private String apiHost = "http://localhost:8080/";
    
    public ArrayList<JSONObject> request(String method, String path, String body){
        switch (method){
            case "GET":
                return getMethod(path, body);
            default:
                return null;
        }
    }
    
    private ArrayList<JSONObject> getMethod(String path, String body){
        try{
            URL url = new URL(apiHost + path);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            
            BufferedReader in = new BufferedReader(
              new InputStreamReader(con.getInputStream()));
            
            String inputLine = null;

            ArrayList<JSONObject> json = new ArrayList<JSONObject>();
            while((inputLine = in.readLine()) != null) {
                json = (ArrayList<JSONObject>) new JSONParser().parse(inputLine);
            }
            
            in.close();

            return json;
        }
        catch(Exception e){
            return null;
        }
    }
    
}