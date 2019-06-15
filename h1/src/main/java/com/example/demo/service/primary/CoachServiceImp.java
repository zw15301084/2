package com.example.demo.service.primary;

import com.example.demo.domain.primary.Coach;
import com.example.demo.domain.primary.Course;
import com.example.demo.repository.primary.CoachRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class CoachServiceImp implements CoachService {

    private CoachRepository coachRepository;

    @Autowired
    public void setCoachRepository(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public Coach login(String username, String password) {
        return getCustomerByNameAndPassword(username, password);
    }

    @Override
    public Coach getCustomerByNameAndPassword(String username, String password) {

        return coachRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void signUp(Coach coach) {
        coachRepository.save(coach);
    }

    @Override
    public void save(Coach coach) {
        coachRepository.save(coach);
    }

    @Override
    public Coach getById(Integer id) {
        Optional<Coach> coach = coachRepository.findById(id);
        return coach.get();
    }

    @Override
    @Cacheable(value = "Coachs'")
    public List<Coach> getRecomCoach() {
        return coachRepository.getRecomCoach();
    }

    @Override
    public Page<Coach> getCourses(int pageNumber, int pageSize) {
        PageRequest request = PageRequest.of(pageNumber,pageSize);
        Page<Coach> coursess= this.coachRepository.findAll(request);
        return coursess;
    }

}