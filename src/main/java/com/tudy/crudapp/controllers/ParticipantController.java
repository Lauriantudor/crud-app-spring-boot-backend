package com.tudy.crudapp.controllers;

import com.tudy.crudapp.model.Participant;
import com.tudy.crudapp.model.Project;
import com.tudy.crudapp.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("participants")
@CrossOrigin("http://localhost:4200/")
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;

    @PostMapping
    public Participant saveParticipant(@RequestBody Participant participant){
         return  participantService.saveParticipant(participant);
    }
    @GetMapping
    public List<Participant> getParticipants(){
        return participantService.getParticipants();
    }
    @GetMapping("{id}")
    public Participant getParticipantById(@PathVariable long id){
        return participantService.getParticipantById(id);
    }

    @PutMapping("{id}")
    public Participant updateParticipant(@PathVariable long id, @RequestBody Participant participant){
        return participantService.updateParticipant(id,participant);
    }
    @PutMapping("{participantId}/assigned/{projectId}")
    public Participant assignProjectToParticipant(@PathVariable long participantId,
                                                  @PathVariable long projectId,
                                                  @RequestBody Project project){
        System.out.println(project);
        return participantService.assignProjectToParticipant(participantId,projectId);
    }
    @PutMapping("{participantId}/remove/{projectId}")
    public Participant removeProjectFromParticipant(@PathVariable long participantId,
                                                  @PathVariable long projectId,
                                                  @RequestBody Project project){
        System.out.println(project);
        return participantService.removeProjectFromParticipant(participantId,projectId);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParticipant(@PathVariable long id){
        participantService.deleteParticipant(id);
    }
}
