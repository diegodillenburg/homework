/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.views;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

/**
 *
 * @author Spiga
 */
@Route(value = "search-form", layout = ProfessorView.class)
@PageTitle("Pesquisa")
@RouteAlias(value = "professor/", layout = ProfessorView.class)
@CssImport("./styles/views/personform/person-form-view.css")
public class SearchView extends Div{
    
}
