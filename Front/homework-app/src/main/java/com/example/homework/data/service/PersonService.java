package com.example.homework.data.service;

import com.example.homework.data.entity.Person;
import com.example.homework.request.HttpRequestClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;
import java.time.LocalDate;
import java.util.ArrayList;
import org.json.simple.JSONObject;

@Service
public class PersonService extends CrudService<Person, Integer> {

    private PersonRepository repository;

    public PersonService(@Autowired PersonRepository repository) {
        this.repository = repository;
    }

    @Override
    protected PersonRepository getRepository() {
        return repository;
    }   
    
    public ArrayList<JSONObject> getRequest(){
        HttpRequestClass resquestClass = new HttpRequestClass();
        return resquestClass.request("GET", "emails", "");
    }

}
