/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unesp.rc.homework.controller;


import com.unesp.rc.homework.model.Email;
import com.unesp.rc.homework.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 *
 * @author Felipe
 */

@RestController
public class EmailController {
    @Autowired
    EmailRepository emailRepository;
    
    @PostMapping("/emails")
    public Email createEmail(@RequestBody Email email) {
        return emailRepository.save(email);
    }
    
    @GetMapping("/emails")
    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }
    
    @GetMapping("/emails/{id}")
    public Optional<Email> getEmailById(@PathVariable(value = "id") Long emailId) {
        return emailRepository.findById(emailId);
    }
}
