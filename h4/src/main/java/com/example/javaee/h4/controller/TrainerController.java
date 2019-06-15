/*package com.example.javaee.h4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaee.h4.entity.Trainer;
import com.example.javaee.h4.service.TrainerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

	private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }
    
    @GetMapping("/show/{id}")
    public Mono<Trainer> findById(@PathVariable String id){
    	return trainerService.getById(Integer.valueOf(id));
    }
	
    @GetMapping("/list")
    public Flux<Trainer> findall(){
    	return trainerService.getAllTrainer();
    }
    
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Trainer> create(@RequestBody Trainer trainer) {
        return trainerService.save(trainer);
    }
    
    @DeleteMapping("/delete/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return trainerService.delete(Integer.valueOf(id));
    }
    
    @PutMapping("/{id}")
    public Mono<Trainer> updateBlog(@RequestBody Trainer trainer, @PathVariable String id) {
    	trainerService.delete(Integer.valueOf(id));
        return trainerService.save(trainer);
    }
    
}
*/