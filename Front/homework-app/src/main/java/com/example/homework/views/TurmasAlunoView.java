/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.views;

import com.example.homework.data.entity.Aluno;
import com.example.homework.data.entity.Matricula;
import com.example.homework.data.entity.Turma;
import com.example.homework.data.service.MatriculaService;
import com.example.homework.data.service.TurmaService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.util.List;
/**
 *
 * @author Spiga
 */
@Route(value = "turmas-aluno", layout = AlunoView.class)
@PageTitle("Listagem de Turmas matriculadas")
@CssImport("./styles/views/personform/person-form-view.css")
public class TurmasAlunoView extends Div {
    
    private MatriculaService matriculaService = new MatriculaService();
    private TurmaService turmaService = new TurmaService();
    
    public TurmasAlunoView() {
        setId("person-form-view");
        addLayouts();
    }

    private void addLayouts() {
        VerticalLayout layout = new VerticalLayout();
        layout.getStyle().set("border", "1px solid #9E9E9E");
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);

        // the default is Alignment.START
        layout.setDefaultHorizontalComponentAlignment(
                FlexComponent.Alignment.STRETCH);

        List<Turma> turmas = turmaService.getAllByAluno(AlunoView.loggedAluno.getId());
        
        turmas.forEach((t) -> {
            FormLayout component = new FormLayout();
            Button button = new Button(t.getNome());
            button.addClickListener(e ->{
                ;
            });
            component.add(button, 2);
            layout.add(component);
        });

        add(layout);
    }
    
}
