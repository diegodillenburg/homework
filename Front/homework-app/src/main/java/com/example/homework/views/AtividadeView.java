/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.views;

import com.example.homework.data.entity.Atividade;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import java.util.Optional;

/**
 *
 * @author Spiga
 */
public class AtividadeView extends Dialog{
    
    private Button sendButton = new Button("Enviar");
    
    public AtividadeView(Optional<Atividade> atividade) {
        FormLayout form = new FormLayout();
        Upload upload = new Upload();
        form.add(new H1("Atividade: " + atividade.get().getTitulo()));
        form.add(new H2("Descrição: " + atividade.get().getDescricao()));
        form.add(upload);
        form.add(sendButton);
        
        form.add(new Span());

        
        this.setWidth("50%");
        this.setHeight("50%");
        this.setDraggable(false);
        this.setModal(true);
        this.add(form);
        this.add(createComentariosBox(atividade.get()));
    }
    
    private VerticalLayout createComentariosBox(Atividade atividade){
            
        VerticalLayout vertical = new VerticalLayout();
        vertical.getStyle().set("border", "1px solid #9E9E9E");
        atividade.getComentarios().forEach((c) -> {
            VerticalLayout lay = new VerticalLayout();
            TextField comentario = new TextField();
            Component component1 = new TextArea();
            lay.add(comentario);
            lay.add(component1);
            if (c.getUsuario().equals(MainView.loggedUser))
                lay.setDefaultHorizontalComponentAlignment(
                FlexComponent.Alignment.END);
            else
                lay.setDefaultHorizontalComponentAlignment(
                FlexComponent.Alignment.START);
        });
        return vertical;
    }
}
