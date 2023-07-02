package com.tudy.crudapp.controllers;


import com.tudy.crudapp.model.Project;
import com.tudy.crudapp.model.Trainer;
import com.tudy.crudapp.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trainers")
@CrossOrigin("http://localhost:4200/")
public class TrainerController {
    @Autowired
    private TrainerService trainerService;

    @PostMapping
    public Trainer saveTrainer(@RequestBody Trainer trainer) {
        return trainerService.saveTrainer(trainer);
    }

    @GetMapping
    public List<Trainer> getTrainers() {
        return trainerService.getTrainers();
    }

    @GetMapping("{id}")
    public Trainer getTrainerById(@PathVariable long id) {
        return trainerService.getTrainerById(id);
    }


    @PutMapping("{id}")
    public Trainer updateTrainer(@PathVariable long id, @RequestBody Trainer trainer) {
        return trainerService.updateTrainer(id, trainer);
    }

    @PutMapping("{trainerId}/assigned/{projectId}")
    public Trainer assignProjectToTrainer(@PathVariable long trainerId, @PathVariable long projectId,
                                          @RequestBody Project project) {
        System.out.println(project);
        return trainerService.assignProjectToTrainer(trainerId, projectId);
    }

    @PutMapping("{trainerId}/remove/{projectId}")
    public Trainer removeProjectFromTrainer(@PathVariable long trainerId, @PathVariable long projectId,
                                            @RequestBody Project project) {
        System.out.println(project);
        return trainerService.removeProjectFromTrainer(trainerId, projectId);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTrainer(@PathVariable long id) {
        trainerService.deleteTrainer(id);
    }

}
