package com.example.demo.service;

import com.example.demo.domain.Coach;
import org.springframework.stereotype.Service;


@Service
public interface CoachService {
    Coach login(String username, String password);

    Coach getCustomerByNameAndPassword(String username, String password);

    void signUp(Coach coach);

    void save(Coach coach);

    Coach getById(Integer id);
}