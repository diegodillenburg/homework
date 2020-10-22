
package com.example.homework.views;

import com.example.homework.data.entity.Aluno;
import com.example.homework.data.entity.Matricula;
import com.example.homework.data.entity.Professor;
import com.example.homework.data.entity.Turma;
import com.example.homework.data.service.AlunoService;
import com.example.homework.data.service.MatriculaService;
import com.example.homework.data.service.ProfessorService;
import com.example.homework.data.service.TurmaService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static javassist.CtMethod.ConstParameter.integer;

@Route(value = "matricula-aluno", layout = AlunoView.class)
@PageTitle("Seção de matrícula")
@CssImport("./styles/views/personform/person-form-view.css")
public class MatriculaView extends Div{
    
    private MatriculaService matriculaService = new MatriculaService();
    private TurmaService turmaService = new TurmaService();
    
    public MatriculaView() {
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

        List<Turma> turmas = turmaService.getAll();
        
        turmas.forEach((t) -> {
            FormLayout component = new FormLayout();
            Button button = new Button("Se inscreva na disciplina: " + t.getNome());
            button.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
            button.addClickListener(e ->{
                long id_aluno = ((Aluno) MainCardView.loggedUsuario).getId();
                Matricula matricula = new Matricula();
                matricula.setAlunoId(id_aluno);
                matricula.setTurmaId(t.getId());
                matriculaService.save(matricula);
                Notification.show("Você se matriculou na disciplina: " + t.getNome());
                button.setEnabled(false);
            });
            component.add(button, 2);
            layout.add(component);
        });

        add(layout);
    }
    
}
