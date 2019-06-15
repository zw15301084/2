package com.example.javaee.demo.service;

import java.util.List;

import com.example.javaee.demo.domain.Course;
import com.example.javaee.demo.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseServiceImp implements CourseService {


    private CourseRepository courseRepository;

    @Autowired
    public void setCustomerRepository(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }
}