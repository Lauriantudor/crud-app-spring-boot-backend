package com.tudy.crudapp.repo;


import com.tudy.crudapp.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepo extends JpaRepository<Trainer,Long> {


}
