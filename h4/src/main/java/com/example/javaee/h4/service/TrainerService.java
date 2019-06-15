package com.example.javaee.h4.service;

import com.example.javaee.h4.entity.Trainer;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface TrainerService {
    Mono<Trainer> save(Trainer coach);
    Mono<Trainer> getById(Integer id);
    Flux<Trainer> getAllTrainer();
    Mono<Trainer> delete(Integer id);
}