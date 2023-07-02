package com.tudy.crudapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Data;

import java.util.*;

@Data
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String organizer;
    @Column
    private String period;
    @Column
    private String place;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedProjects")
    private List<Trainer> trainers = new ArrayList<>();


    @JsonIgnore
    @ManyToMany(mappedBy = "participantsProjects")
    private List<Participant> participants= new ArrayList<>();
}
