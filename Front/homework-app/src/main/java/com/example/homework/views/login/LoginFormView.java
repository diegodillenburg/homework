/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.views.login;

import com.example.homework.data.entity.Aluno;
import com.example.homework.data.entity.Professor;
import com.example.homework.data.entity.Usuario;
import com.example.homework.data.service.UsuarioService;
import com.example.homework.views.main.MainView;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.AbstractLogin.LoginEvent;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.net.http.HttpResponse;

/**
 *
 * @author Spiga
 */
@Route(value = "login-form", layout = MainView.class)
@PageTitle("Login Form")
public class LoginFormView extends HorizontalLayout {

    private Usuario loggedUser = new Usuario();
    
    private Button loginButton = new Button("Login");

    private Button logoutButton = new Button("Logout");
    
    private LoginOverlay component = new LoginOverlay();
    
    private UsuarioService usuarioService = new UsuarioService();
    
    private Binder<Usuario> binder = new Binder<>(Usuario.class);
    
    private ObjectMapper mapper = new ObjectMapper();
    
    public LoginFormView() {

        loginButton.setVisible(true);
        logoutButton.setVisible(false);
        
        loginButton.addClickListener(
                e -> component.setOpened(true));
        
        logoutButton.addClickListener( e -> {
                loginButton.setVisible(true);
                logoutButton.setVisible(false);
            }
        );
        
        component.addLoginListener(e -> {
            boolean isAuthenticated = authenticate(e);
            
            if (isAuthenticated) {
                loginButton.setVisible(false);
                logoutButton.setVisible(true);
                component.close();
            } else {
                component.setError(true);
            }
        });

        add(component, loginButton, logoutButton);
        
    }

    private boolean authenticate(LoginEvent e) {
        String user = e.getUsername();
        String password = e.getPassword();
        
        HttpResponse response = usuarioService.autenticar(user, password);
        
        if(response != null){
            try{
                mapper.registerSubtypes(new NamedType(Aluno.class, "Aluno"));
                mapper.registerSubtypes(new NamedType(Professor.class, "Professor"));
                loggedUser = mapper.readValue(response.body().toString(), Usuario.class);
                return true;
            }catch(JsonProcessingException ex){
                return false;
            }
        }
        
        return false;
    }
}
