package com.tudy.crudapp.services;



import com.tudy.crudapp.model.Project;
import com.tudy.crudapp.model.Trainer;
import com.tudy.crudapp.repo.ProjectRepo;
import com.tudy.crudapp.repo.TrainerRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TrainerService {
    @Autowired
    private TrainerRepo trainerRepo;
    @Autowired
    private ProjectRepo projectRepo;


    public Trainer saveTrainer(Trainer trainer){

        return trainerRepo.save(trainer);
    }

    public List<Trainer> getTrainers(){

        return trainerRepo.findAll();
    }
    public Trainer getTrainerById(long id){

        return trainerRepo.findById(id).orElse(null);
    }
    public Trainer updateTrainer(long id, Trainer trainer){
        Trainer exitingTrainer = trainerRepo.findById(id).orElse(null);
        exitingTrainer.setName(trainer.getName());
        exitingTrainer.setEmail(trainer.getEmail());
        exitingTrainer.setInstitution(trainer.getInstitution());
        exitingTrainer.setPhoneNumber(trainer.getPhoneNumber());


        return trainerRepo.save(exitingTrainer);
    }


    public void deleteTrainer(long id){

        trainerRepo.deleteById(id);
    }


    public Trainer assignProjectToTrainer(long trainerId, long projectId) {
        List<Project> projectSet =null;
        Trainer trainer = trainerRepo.findById(trainerId).get();
        Project project = projectRepo.findById(projectId).get();
        projectSet = trainer.getAssignedProjects();
        projectSet.add(project);
        trainer.setAssignedProjects(projectSet);

        return trainerRepo.save(trainer);
    }


    public Trainer removeProjectFromTrainer(long trainerId, long projectId) {

        Trainer trainer = trainerRepo.findById(trainerId).get();
        Project project = projectRepo.findById(projectId).get();
        if (trainer != null){
            trainer.getAssignedProjects().remove(project);
            project.getTrainers().remove(trainer);
            return trainer;
        }
        return trainer;
    }
    }

