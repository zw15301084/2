package com.example.javaee.h4.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.javaee.h4.entity.Trainer;
import com.example.javaee.h4.repository.TrainerRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TrainerServiceImp implements TrainerService {

    private TrainerRepository trainerRepository;

    @Autowired
    public TrainerServiceImp(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }


    public Mono<Trainer> save(Trainer coach) {
    	Trainer trainer = trainerRepository.save(coach);
        return Mono.just(trainer);
    }

    public Mono<Trainer> getById(Integer id) {
    	Trainer trainer = trainerRepository.findById(id).get();
    	
        Mono<Trainer> coach = Mono.just(trainer);
        System.out.println(coach);
        return coach;
    }

	@Override
	public Flux<Trainer> getAllTrainer() {
		//return trainerRepository.getAllTrainer();
		
		Iterable<Trainer> cIterable = trainerRepository.findAll();
		System.out.println(cIterable.toString());
		Iterator<Trainer> iter = cIterable.iterator();
		List<Trainer> coachs = new ArrayList<>();
		while(iter.hasNext()) {
			System.out.println(iter.hasNext());
			coachs.add(iter.next());
		}
		Flux<Trainer> trainers = Mono.just(coachs).flatMapMany(Flux::fromIterable);
		return trainers;
		
	}

	@Override
	public Mono<Trainer> delete(Integer id) {
		Trainer trainer = trainerRepository.getOne(id);
		trainerRepository.deleteById(id);
		return Mono.just(trainer);
	}
}