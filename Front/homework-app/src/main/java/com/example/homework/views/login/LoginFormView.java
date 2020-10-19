/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.views.login;

import com.example.homework.views.main.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

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
    
    public LoginFormView() {

        loginButton.setVisible(true);
        logoutButton.setVisible(false);
        
        component.addLoginListener(e -> component.close());
        loginButton.addClickListener(
                e -> component.setOpened(true));
        
        logoutButton.addClickListener( e -> {
                loginButton.setVisible(true);
                logoutButton.setVisible(false);
            }
        );
        
        component.addLoginListener(e -> {
            boolean isAuthenticated = authenticate();
            
            if (isAuthenticated) {
                loginButton.setVisible(false);
                logoutButton.setVisible(true);
            } else {
                component.setError(true);
            }
        });

        add(component, loginButton, logoutButton);
        
    }

    private boolean authenticate() {
        if(true)
            return true;
        
        return false;
    }
}
