/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.views;

import com.example.homework.data.entity.Aluno;
import com.example.homework.data.entity.Professor;
import com.example.homework.data.entity.Turma;
import com.example.homework.data.service.AlunoService;
import com.example.homework.data.service.ProfessorService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static javassist.CtMethod.ConstParameter.integer;

/**
 *
 * @author Spiga
 */
@Route(value = "turma-form", layout = ProfessorView.class)
@PageTitle("Cadastro de turmas")
@CssImport("./styles/views/personform/person-form-view.css")
public class TurmaProfView extends Div{
    
    private TextField nome = new TextField("Disciplina");
    private DatePicker inicio_aulas = new DatePicker("Início das aulas");
    private DatePicker fim_aulas = new DatePicker("Fim das aulas");
    private DatePicker inicio_inscricoes = new DatePicker("Início das inscrições");
    private DatePicker fim_inscricoes = new DatePicker("Fim das inscrições");
    private TextField max_alunos = new TextField("Número máximo de alunos");
    
    private Grid alunosGrid = new Grid();

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");
    
    private ProfessorService professorService = new ProfessorService();
    private AlunoService alunoService = new AlunoService();
    
    public TurmaProfView() {
        setId("person-form-view");
        add(createFormLayout());
    }
    private FormLayout createFormLayout(){
        FormLayout formLayout = new FormLayout();
        
        formLayout.add(nome, 2);
        formLayout.add(inicio_aulas, fim_aulas);
        formLayout.add(inicio_inscricoes, fim_inscricoes);
        
        max_alunos.setPattern("\\d*");
        max_alunos.setErrorMessage("Somente números");
        
        formLayout.add(max_alunos);
        formLayout.add(buttonLayout(), 2);
        
        return formLayout;
    }

    private Component buttonLayout() {
        
        FormLayout formLayout = new FormLayout();
        formLayout.add(save,cancel);
        
        save.addClickListener(e -> {
            saveTurma();
            Notification.show("Usuario salvo.");
        });
        return formLayout;
    }

    private void saveTurma() {
        Turma turma = new Turma();
        turma.setCarga_total(0);
        turma.setData_inicio_aulas(Date.from(inicio_aulas.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        turma.setData_fim_aulas(Date.from(fim_aulas.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        turma.setData_inicio_inscricao(Date.from(inicio_inscricoes.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        turma.setData_fim_inscricao(Date.from(fim_inscricoes.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        turma.setMax_alunos(Integer.parseInt(max_alunos.getValue()));
        turma.setNome(nome.getValue());
        turma.setProfessor((Professor) MainCardView.loggedUsuario);
        
        }
    
}
