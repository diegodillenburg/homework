/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.views;

import com.example.homework.data.entity.Atividade;
import com.example.homework.data.entity.Comentario;
import com.example.homework.data.entity.Usuario;
import com.example.homework.data.service.ComentarioService;
import com.example.homework.data.service.UsuarioService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Spiga
 */
public class AtividadeView extends Dialog{
    
    private UsuarioService usuarioService = new UsuarioService();
    private ComentarioService comentarioService = new ComentarioService();
    
    private VerticalLayout commentBox = new VerticalLayout();
    
    private Button sendButton = new Button("Enviar");
    
    private List<Comentario> lista = new ArrayList<Comentario>();
    
    private Atividade atividade = new Atividade();
    
    public AtividadeView(Optional<Atividade> atividade) {
        this.atividade = atividade.get();
        FormLayout form = new FormLayout();
        Upload upload = new Upload();
        form.add(new H1("Atividade: " + atividade.get().getTitulo()));
        form.add(new H2("Descrição: " + atividade.get().getDescricao()));
        form.add(sendButton);
        
        form.add(new Span());

        this.setWidth("50%");
        this.setHeight("80%");
        this.setDraggable(false);
        this.setModal(true);
        this.add(form);
        this.add(upload);
        
        this.add(createComentariosBox());
        populateBox();
        
        this.add(createSendRegion());
        
    }
    
    private VerticalLayout createComentariosBox(){
            
        commentBox.setHeight("100%");
        commentBox.setSizeUndefined();
        commentBox.getStyle().set("border", "1px solid #9E9E9E");

        return commentBox;
    }

    private void populateBox() {
        
        atividade.getComentarios().forEach(c -> {
            if (lista.contains(c))
                ;
            else{
                
                Usuario user = usuarioService.getUserByComment(c.getId());
                VerticalLayout lay = new VerticalLayout();

                TextField comentario = new TextField();
                comentario.setTitle(user.getNome());
                comentario.setValue(c.getTexto());
                lay.add(comentario);

                if (user.equals(MainCardView.loggedUsuario))
                    lay.setDefaultHorizontalComponentAlignment(
                    FlexComponent.Alignment.END);
                else
                    lay.setDefaultHorizontalComponentAlignment(
                    FlexComponent.Alignment.START);
            
                commentBox.add(lay);
                lista.add(c);
            }
        });
    }
    
    private Component createSendRegion() {
        HorizontalLayout layout = new HorizontalLayout();
        
        TextField text = new TextField();
        text.setWidth("350%");
        layout.add(text);
        
        sendButton.addClickListener(e -> {
            if(text.getValue().isBlank()){
                text.setValue("");
                return;
            }
            
            Comentario comment = new Comentario();
            comment.setAtividade_id(atividade.getId());
            comment.setTexto(text.getValue());
            comment.setUsuario(MainCardView.loggedUsuario);
            comment = comentarioService.save(comment);
            List<Comentario> list = atividade.getComentarios();
            list.add(comment);
            atividade.setComentarios(list);
            populateBox();
            text.setValue("");
        });
        sendButton.setWidthFull();
        layout.add(sendButton);
        return layout;
    }
    
}
