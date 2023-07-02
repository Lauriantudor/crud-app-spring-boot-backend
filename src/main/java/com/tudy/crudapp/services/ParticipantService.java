package com.tudy.crudapp.services;

import com.tudy.crudapp.model.Participant;
import com.tudy.crudapp.model.Project;
import com.tudy.crudapp.repo.ParticipantRepo;
import com.tudy.crudapp.repo.ProjectRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ParticipantService {

    @Autowired
    private ParticipantRepo participantRepo;
    @Autowired
    private ProjectRepo projectRepo;


    public Participant saveParticipant(Participant participant){
        return participantRepo.save(participant);
    }
    public List<Participant> getParticipants(){
        return participantRepo.findAll();
    }
    public  Participant getParticipantById(long id){
        return participantRepo.findById(id).orElse(null);
    }
    public Participant updateParticipant(long id, Participant participant){
        Participant exitingParticipant = participantRepo.findById(id).orElse(null);
        exitingParticipant.setName(participant.getName());
        exitingParticipant.setEmail(participant.getEmail());
        exitingParticipant.setPhoneNumber(participant.getPhoneNumber());
        exitingParticipant.setLastSchool(participant.getLastSchool());

        return participantRepo.save(exitingParticipant);
    }

    public void deleteParticipant(long id){
        participantRepo.deleteById(id);
    }

    public Participant assignProjectToParticipant(long participantId, long projectId){
        List<Project> projectList = null;
        Participant participant = participantRepo.findById(participantId).orElse(null);
        Project project = projectRepo.findById(projectId).orElse(null);
        projectList = participant.getParticipantsProjects();
        projectList.add(project);
        participant.setParticipantsProjects(projectList);

        return participantRepo.save(participant);
    }
    public Participant removeProjectFromParticipant(long participantId, long projectId){

        Participant participant = participantRepo.findById(participantId).orElse(null);
        Project project = projectRepo.findById(projectId).orElse(null);
        if (participant !=null){
            participant.getParticipantsProjects().remove(project);
            project.getParticipants().remove(participant);

            return participant;
        }
        return participant;
    }
}
