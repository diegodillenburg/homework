/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.views;

import com.example.homework.data.entity.Aluno;
import com.example.homework.data.entity.Professor;
import com.example.homework.data.service.AlunoService;
import com.example.homework.data.service.ProfessorService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.PasswordField;
/**
 *
 * @author Spiga
 */
@Route(value = "registrar")
@PageTitle("Registrar")
@CssImport("./styles/views/registrarform/registrar-view.css")
class RegistrarView extends Div {

    private TextField login = new TextField("Login");
    private PasswordField senha = new PasswordField("Senha");
    
    private TextField nome = new TextField("Nome completo");
    private TextField endereco = new TextField("Endereço Completo");
    private TextField telefone = new TextField("Telefone");
    private TextField email = new TextField("E-mail");
    
    private TextField departamento = new TextField("Departamento");
    private RadioButtonGroup<String> efetivo = new RadioButtonGroup<String>();
    
    private TextField periodo = new TextField("Periodo");
    private TextField instituicao = new TextField("Instituição");
    
    private ComboBox<String> usuarioType = new ComboBox<>("Tipo de acesso");

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");
    
    private ProfessorService professorService = new ProfessorService();
    private AlunoService alunoService = new AlunoService();
    
    public RegistrarView() {
        setId("registrar-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());
        
        cancel.addClickListener(e ->{
            UI.getCurrent().removeAll();
            UI.getCurrent().navigate(MainCardView.class);
        });
        
        save.addClickListener(e -> {
            registrar();
            Notification.show("Usuario salvo.");
            UI.getCurrent().removeAll();
            UI.getCurrent().navigate(MainCardView.class);
        });
    } 

    private Component createTitle() {
        return new H3("Registro");
    }

    private Component createFormLayout() {
        
        FormLayout formLayout = new FormLayout();
        changeVisibility("");
        
        usuarioType.setItems("Professor", "Aluno");
        usuarioType.addValueChangeListener(e -> {
            if (e.getValue().equalsIgnoreCase("Professor"))
                changeVisibility("Professor");
            else
                changeVisibility("Aluno");
        });        
        formLayout.add(usuarioType, 2);
        formLayout.add(nome, 2);
        formLayout.add(endereco, 2);
        formLayout.add(telefone, email);
        formLayout.add(login, senha);
        
        efetivo.setLabel("É efetivo?");
        efetivo.setItems("Sim", "Não");
        efetivo.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
        efetivo.setValue("Sim");
        
        formLayout.add(efetivo,departamento);
        formLayout.add(periodo,instituicao);
        
        return formLayout;
    }
    
    private void changeVisibility(String type){
        if (type.equalsIgnoreCase("Professor"))
        {
            efetivo.setVisible(true);
            departamento.setVisible(true);
            periodo.setVisible(false);
            instituicao.setVisible(false);
        }
        else if (type.equalsIgnoreCase("Aluno"))
        {
            efetivo.setVisible(false);
            departamento.setVisible(false);
            periodo.setVisible(true);
            instituicao.setVisible(true);
        }
        else
        {
            efetivo.setVisible(false);
            departamento.setVisible(false);
            periodo.setVisible(false);
            instituicao.setVisible(false);
        }
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }
    
    private void registrar(){
        
        String element = usuarioType.getValue();
        
        if(element.equalsIgnoreCase("Professor")){
            Professor professor = new Professor();
            professor.setEmail(email.getValue());
            professor.setEndereco(endereco.getValue());
            professor.setLogin(login.getValue());
            professor.setNome(nome.getValue());
            professor.setSenha(senha.getValue());
            professor.setTelefone(telefone.getValue());
            professor.setDepartamento(departamento.getValue());
            professor.setEfetivo(efetivo.getValue().equalsIgnoreCase("Sim") ? true : false);
            
            professorService.saveProfessor(professor);
        }
        else{
            Aluno aluno = new Aluno();
            aluno.setEmail(email.getValue());
            aluno.setEndereco(endereco.getValue());
            aluno.setLogin(login.getValue());
            aluno.setNome(nome.getValue());
            aluno.setSenha(senha.getValue());
            aluno.setTelefone(telefone.getValue());
            aluno.setInstituicao(instituicao.getValue());
            aluno.setPeriodo(periodo.getValue());
            
            alunoService.saveAluno(aluno);
        
        }
    }

}
