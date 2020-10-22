/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.views;

import com.example.homework.data.entity.Aluno;
import com.example.homework.data.entity.Professor;
import com.example.homework.data.entity.Usuario;
import com.example.homework.data.service.UsuarioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.PWA;
import java.net.http.HttpResponse;

/**
 *
 * @author Spiga
 */
@PWA(name = "Homework", shortName = "Homework", enableInstallPrompt = false)
@Route("")
public class MainCardView extends VerticalLayout implements RouterLayout{
    
    HorizontalLayout horizontal = new HorizontalLayout();
    
    public static Usuario loggedUsuario = new Usuario();
    
    Text text = new Text("HomeWork Web App");
    
    Button login = new Button("Login");
    
    Button registrar = new Button("Registrar");
    
    public LoginOverlay component = new LoginOverlay();
    
    private UsuarioService usuarioService = new UsuarioService();
    
    private ObjectMapper mapper = new ObjectMapper();
    
    private final Div content = new Div();
    
    public MainCardView(){
        
        login.addThemeVariants(ButtonVariant.LUMO_LARGE,
        ButtonVariant.LUMO_PRIMARY);
        
        registrar.addThemeVariants(ButtonVariant.LUMO_LARGE,
        ButtonVariant.LUMO_PRIMARY);
        registrar.addClickListener(e ->{
            UI.getCurrent().navigate(RegistrarView.class);
        });
        
        setHeightFull();
        setWidthFull();
        
        horizontal.add(createLoginButton(), createRegistrarButton());
        horizontal.setVerticalComponentAlignment(Alignment.CENTER, login, registrar);    

        add(text, horizontal);

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }
    
    private Button createLoginButton(){
    
        login.addClickListener(
                e -> component.setOpened(true));
        
        component.addLoginListener(e -> {
            boolean isAuthenticated = authenticate(e);
            
            if (isAuthenticated) {
                component.close();
                if(true)
                    UI.getCurrent().navigate(ProfessorView.class);
            } else {
                component.setError(true);
            }
        });
        
        return login;
    }
    
    private Button createRegistrarButton(){
        return registrar;
    }
    
    private boolean authenticate(AbstractLogin.LoginEvent e) {
        String user = e.getUsername();
        String password = e.getPassword();
        
        HttpResponse response = usuarioService.autenticar(user, password);
        
        if(response != null){
            try{
                mapper.registerSubtypes(new NamedType(Aluno.class, "Aluno"));
                mapper.registerSubtypes(new NamedType(Professor.class, "Professor"));
                MainCardView.loggedUsuario = mapper.readValue(response.body().toString(), Usuario.class);
                return true;
            }catch(JsonProcessingException ex){
                return false;
            }
        }
        
        return false;
    }
}
