package com.example.homework.views.email;

import com.example.homework.data.model.Email;
import com.example.homework.data.service.EmailService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.example.homework.views.main.MainView;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.grid.Grid;
import java.util.ArrayList;
import org.json.simple.JSONObject;

@Route(value = "email-form", layout = MainView.class)
@PageTitle("Email Form")
@CssImport("./styles/views/personform/person-form-view.css")
public class EmailView extends Div {

    private String[] vec = {};
    private Button load = new Button("Carregar emails");
    
    private Grid<Email> grid = new Grid<>(Email.class);

    public EmailView(EmailService emailService) {
        setId("email-form-view");

        add(createTitle());
        add(createButtonLayout());
        add(creatListLayout());

        load.addClickListener(e -> {
            grid.setItems(proccessEmails( emailService.getRequest()));
        });
    }
    
    private ArrayList<Email> proccessEmails(ArrayList<JSONObject> items) {
        
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Email> emails = new ArrayList<Email>();
        
        try
        {
            for(JSONObject item : items){
                Email data = mapper.readValue(item.toString(), Email.class);
                emails.add(data);
            }
        }
        catch(Exception e)
        {
            return null;
        }
        return emails;
    }

    private Component createTitle() {
        return new H3("Emails");
    }
    
    private Component creatListLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(grid);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        load.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(load);
        return buttonLayout;
    }
}
