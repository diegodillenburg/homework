/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.views.login;

import com.example.homework.data.entity.Usuario;
import com.example.homework.data.service.LoginRepository;
import com.example.homework.data.service.LoginService;
import com.example.homework.views.main.MainView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.AbstractLogin.LoginEvent;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.json.simple.JSONObject;

/**
 *
 * @author Spiga
 */
@Route(value = "login-form", layout = MainView.class)
@PageTitle("Login Form")
public class LoginFormView extends HorizontalLayout {

    private Button loginButton = new Button("Login");

    private Button logoutButton = new Button("Logout");
    
    private LoginOverlay component = new LoginOverlay();
    
    private LoginService loginService = new LoginService();
    
    private Binder<Usuario> binder = new Binder<>(Usuario.class);
    
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
        
        JSONObject teste = loginService.autenticar(user, password);
        
        if(user.equals("pedro") && password.equals("teste"))
            return true;
        
        return false;
    }
}
