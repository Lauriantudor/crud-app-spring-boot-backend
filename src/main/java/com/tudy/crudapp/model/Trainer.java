package com.tudy.crudapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@Entity
@NoArgsConstructor

@Table(name = "trainers")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String institution;

    @Column
    private String phoneNumber;

    @ManyToMany()
    @JoinTable(name = "trainers_projects",
    joinColumns = @JoinColumn(name ="trainer_id"),
    inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> assignedProjects=new ArrayList<>();




}
