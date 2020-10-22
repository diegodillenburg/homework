
package com.example.homework.views;

import com.example.homework.data.entity.Atividade;
import com.example.homework.data.entity.Turma;
import com.example.homework.data.service.AtividadeService;
import com.example.homework.data.service.UsuarioService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;

public class NovaAtividadeView extends Dialog {
    
    private UsuarioService usuarioService = new UsuarioService();
    
    private TextField titulo = new TextField();
    private TextArea descricao = new TextArea();
    
    private ListBox<String> tipo_atividade = new ListBox();
    
    private Button saveButton = new Button("Salvar");
    
    private Atividade atividade = new Atividade();
    
    private AtividadeService atividadeService = new AtividadeService();
    
    public NovaAtividadeView(Turma turma) {
        
        FormLayout form = new FormLayout();
        Upload upload = new Upload();
        
        form.add(new H1("Cadastro de Atividade"),2);
        
        tipo_atividade.setItems("Aula","Entrega");
        form.add(titulo, tipo_atividade);
        form.add(descricao, 2);
        
        
        saveButton.addClickListener(e -> {
            atividade.setDescricao(descricao.getValue());
            atividade.setTipoAtividade(tipo_atividade.getValue());
            atividade.setTitulo(titulo.getValue());
            atividade.setTurmaId(turma.getId());
            
            atividade = atividadeService.save(atividade);
            Notification.show("Atividade gravada com sucesso!");
        });
        form.add(saveButton);
        
        this.setWidth("50%");
        this.setHeight("80%");
        this.setDraggable(false);
        this.setModal(true);
        this.add(form);
        this.add(upload);
        
    }
    
}
