package com.example.demo.service.secondary;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.secondary.Trainer;


@Service
public interface TrainerService {

    void save(Trainer coach);

    Trainer getById(Integer id);

    Trainer getCustomerByNameAndPassword(String username, String password);
    
    List<Trainer> getAllTrainer();
    
    void delete(Integer id);
}