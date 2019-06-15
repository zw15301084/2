package com.example.javaee.h4.controller;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import com.example.javaee.h4.entity.Trainer;
import com.example.javaee.h4.service.TrainerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class TrainerHandler {

    private final TrainerService trainerService;

    @Autowired
    public TrainerHandler(TrainerService trainerService) {
        this.trainerService = trainerService;
    }
    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(trainerService.getById(Integer.valueOf(id)), Trainer.class);
    }
    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(trainerService.getAllTrainer(), Trainer.class);
    }
    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Trainer> trainer = request.bodyToMono(Trainer.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(trainer.flatMap(trainerService::save), Trainer.class));
        		
    }
    public Mono<ServerResponse> delete(ServerRequest request) {
        String id = request.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(trainerService.delete(Integer.valueOf(id)), Trainer.class);
    }

    public Mono<ServerResponse> update(ServerRequest request){
        String id = request.pathVariable("id");
        trainerService.delete(Integer.valueOf(id));
        final Mono<Trainer> trainer = request.bodyToMono(Trainer.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(trainer.flatMap(trainerService::save), Trainer.class));
    }
}