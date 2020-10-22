/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.views;

import com.example.homework.data.entity.Aluno;
import com.example.homework.data.entity.Atividade;
import com.example.homework.data.entity.Professor;
import com.example.homework.data.entity.Turma;
import com.example.homework.data.entity.Usuario;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Spiga
 */
public class AtividadeTurmaView extends Dialog{
    
    private Button button = new Button();
    
    private Usuario user = new Usuario();
    
    private Turma turma = new Turma();
    
    public AtividadeTurmaView(Turma turma) {
        
        user = MainCardView.loggedUsuario;
        this.turma = turma;
        
        FormLayout form = new FormLayout();
        
        Class u = user.getClass();
        if(u.equals(Professor.class)){
            form.add(new H1("Turma: " + turma.getNome()));
            form.add(createAtividade());
        }
        else{
            form.add(new H1("Turma: " + turma.getNome()),2);
        }
        
        
        form.add(new H2("Professor: " + turma.getProfessor().getNome()),2);
        Label label = new Label("Número máximo de alunos: " + Integer.toString(turma.getMax_alunos()));
        
        Span span1 = new Span("Inicio das inscrições: " + formatDate(turma.getData_inicio_inscricao()));
        Span span2 = new Span("Fim das inscrições: " + formatDate(turma.getData_fim_inscricao()));
        Span span3 = new Span("Inicio das aulas: " + formatDate(turma.getData_inicio_aulas()));
        Span span4 = new Span("Fim das aulas: " + formatDate(turma.getData_fim_aulas()));
        
        form.add(label, 2);
        form.add(span1,span3);
        form.add(span2,span4);
        form.add(new Span());
        
        form.add(createGrid(turma), 2);
        
        this.setWidth("50%");
        this.setHeight("50%");
        this.setDraggable(false);
        this.setModal(true);
        this.add(form);
    }
    
    private void init (String elementType){
    
    }
    
    private String formatDate(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");  
        String strDate = dateFormat.format(date); 
        return strDate;
    }
    
    private Grid createGrid(Turma turma){
        Grid<Atividade> grid = new Grid<>(Atividade.class);
        grid.setItems(turma.getAtividades());
        grid.removeAllColumns();
        grid.addColumn(Atividade::getTitulo).setHeader("Titulo");
        grid.addColumn(Atividade::getTipoAtividade).setHeader("Tipo");
        grid.addColumn(Atividade::getDescricao).setHeader("Descricao");
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER,
        GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES);
        
        grid.addSelectionListener(e -> {
            AtividadeView dialog = new AtividadeView(e.getFirstSelectedItem());
            dialog.open();
        });
        
        return grid;
    }

    private Button createAtividade() {
        Button button = new Button("Criar Atividade");
        button.addClickListener(e ->{
            NovaAtividadeView dialog = new NovaAtividadeView(turma);
            dialog.open();
        });
        return button;
    }
    
}
