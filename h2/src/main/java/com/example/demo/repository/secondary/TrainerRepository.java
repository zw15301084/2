package com.example.demo.repository.secondary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.secondary.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

    @Query(value = "select * from trainer where username=?1 and password=?2", nativeQuery = true)
    Trainer findByUsernameAndPassword(String username, String password);
    
    @Query(value = "select * from trainer", nativeQuery = true)
    List<Trainer> getAllTrainer();

}