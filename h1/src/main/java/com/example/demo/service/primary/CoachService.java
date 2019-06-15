package com.example.demo.service.primary;

import com.example.demo.domain.primary.Coach;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CoachService {
    Coach login(String username, String password);

    Coach getCustomerByNameAndPassword(String username, String password);

    void signUp(Coach coach);

    void save(Coach coach);

    Coach getById(Integer id);

    List<Coach> getRecomCoach();

    Page<Coach> getCourses(int pageNumber, int pageSize);
}