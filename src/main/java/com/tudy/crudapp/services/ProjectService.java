package com.tudy.crudapp.services;


import com.tudy.crudapp.model.Participant;
import com.tudy.crudapp.model.Project;
import com.tudy.crudapp.model.Trainer;
import com.tudy.crudapp.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo projectRepo;

    public Project saveProject(Project project){
        return projectRepo.save(project);
    }

    public List<Project> getProjects(){
        return projectRepo.findAll();
    }
    public Project getProjectById(long id){
        return projectRepo.findById(id).orElse(null);
    }
    public Project updateProject(long id, Project project){
        Project exitingProject = projectRepo.findById(id).orElse(null);
        exitingProject.setTitle(project.getTitle());
        exitingProject.setDescription(project.getDescription());
        exitingProject.setOrganizer(project.getOrganizer());
        exitingProject.setPeriod(project.getPeriod());
        exitingProject.setPlace(project.getPlace());

        return projectRepo.save(exitingProject);
    }
    public List<Trainer> getTrainerByProject(long id ){
        Project findedProject = projectRepo.findById(id).orElse(null);
        return findedProject.getTrainers();
    }

    public List<Participant> getParticipantByProject(long id){
        Project findProject = projectRepo.findById(id).orElse(null);
        return findProject.getParticipants();
    }

    public void deleteProject(long id){
        projectRepo.deleteById(id);
    }
}
