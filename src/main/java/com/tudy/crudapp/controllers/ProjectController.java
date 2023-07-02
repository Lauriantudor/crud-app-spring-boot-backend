package com.tudy.crudapp.controllers;


import com.tudy.crudapp.model.Participant;
import com.tudy.crudapp.model.Project;
import com.tudy.crudapp.model.Trainer;
import com.tudy.crudapp.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("projects")
@CrossOrigin("http://localhost:4200/")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping
    public Project saveProject(@RequestBody Project project) {
        return projectService.saveProject(project);
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectService.getProjects();
    }

    @GetMapping("{id}")
    public Project getProjectById(@PathVariable long id){
        return  projectService.getProjectById(id);
    }


    @GetMapping("projectTrainer/{id}")
    public List<Trainer> getTrainerByProject(@PathVariable long id) {
        return projectService.getTrainerByProject(id);
    }

    @GetMapping("projectParticipant/{id}")
    public List<Participant> getParticipantByProject(@PathVariable long id){
        return projectService.getParticipantByProject(id);
    }
    @PutMapping("{id}")
    public Project updateProject(@PathVariable long id, @RequestBody Project project) {
        return projectService.updateProject(id, project);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable long id) {
        projectService.deleteProject(id);
    }
}
