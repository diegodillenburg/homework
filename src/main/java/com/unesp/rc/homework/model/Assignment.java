package com.unesp.rc.homework.model;


import javax.persistence.*;

@Entity
@Table(name = "assignments")
public class Assignment {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String description;

    private String assignmentType;

    public Assignment() {
        super();
    }

    public Assignment(Long id, String title, String description, String assignmentType) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.assignmentType = assignmentType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignmentType() {
        return assignmentType;
    }

    public void setAssignmentType(String assignmentType) {
        this.assignmentType = assignmentType;
    }
}
