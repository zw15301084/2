package com.example.demo.service;

import com.example.demo.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface CourseService {

    Course save(Course course);

    Course findByName(String s);

    Page<Course> getCourses(int pageNumber,int pageSize);
}
