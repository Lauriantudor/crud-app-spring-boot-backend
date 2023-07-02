package com.tudy.crudapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "participants")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phoneNumber;
    @Column
    private String lastSchool;

    @ManyToMany()
    @JoinTable(name = "participants_projects",
    joinColumns = @JoinColumn(name = "participant_id"),
    inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> participantsProjects= new ArrayList<>();
}
