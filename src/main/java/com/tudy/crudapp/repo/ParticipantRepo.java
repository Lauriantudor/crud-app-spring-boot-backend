package com.tudy.crudapp.repo;

import com.tudy.crudapp.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepo extends JpaRepository<Participant, Long> {
}
