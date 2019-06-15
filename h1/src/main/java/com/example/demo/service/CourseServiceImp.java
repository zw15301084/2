package com.example.demo.service;

import com.example.demo.domain.Course;
import com.example.demo.repository.CourseRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class CourseServiceImp implements CourseService {


    @Autowired
    CourseRepositroy courseRepositroy;

    @Override
    public Course save(Course course) {
        return courseRepositroy.save(course);
    }

    @Override
    public Course findByName(String s) {
        return courseRepositroy.findByName(s);
    }

    @Override
    public Page<Course> getCourses(int pageNumber, int pageSize) {
        PageRequest request = PageRequest.of(pageNumber,pageSize);
        Page<Course> coursess= this.courseRepositroy.findAll(request);
        return coursess;
    }


}
