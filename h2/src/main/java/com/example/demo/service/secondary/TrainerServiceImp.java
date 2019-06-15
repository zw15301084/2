package com.example.demo.service.secondary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.secondary.Trainer;
import com.example.demo.repository.secondary.TrainerRepository;


@Component
public class TrainerServiceImp implements TrainerService {

    private TrainerRepository trainerRepository;

    @Autowired
    public void setTrainerRepository(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }


    public Trainer getCustomerByNameAndPassword(String username, String password) {
        return trainerRepository.findByUsernameAndPassword(username, password);
    }


    public void save(Trainer coach) {
        trainerRepository.save(coach);
    }

    public Trainer getById(Integer id) {
        Optional<Trainer> coach = trainerRepository.findById(id);
        System.out.println(coach.toString());
        return coach.get();
    }

	@Override
	public List<Trainer> getAllTrainer() {
		//return trainerRepository.getAllTrainer();
		Iterable<Trainer> cIterable = trainerRepository.findAll();
		System.out.println(cIterable.toString());
		Iterator<Trainer> iter = cIterable.iterator();
		List<Trainer> coachs = new ArrayList<>();
		while(iter.hasNext()) {
			System.out.println(iter.hasNext());
			coachs.add(iter.next());
		}
		return coachs;
	}

	@Override
	public void delete(Integer id) {
		trainerRepository.deleteById(id);		
	}

}