package com.example.javaee.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.example.javaee.demo.domain.Course;


@Service
public interface CourseService {
    

    List<Course> getAll();
}