package com.example.homework.data.service;

import com.example.homework.data.model.Email;
import com.example.homework.request.HttpRequestClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;
import java.util.ArrayList;
import org.json.simple.JSONObject;

@Service
public class EmailService extends CrudService<Email, Integer> {

    private EmailRepository repository;

    public EmailService(@Autowired EmailRepository repository) {
        this.repository = repository;
    }

    @Override
    protected EmailRepository getRepository() {
        return repository;
    }   
    
    public ArrayList<JSONObject> getRequest(){
        HttpRequestClass resquestClass = new HttpRequestClass();
        return resquestClass.request("GET", "emails", "");
    }

}
