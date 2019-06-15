package com.example.demo.service.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.example.demo.domain.primary.Course;
import com.example.demo.repository.primary.CourseRepositroy;

@Component
public class CourseServiceImp implements CourseService {




    CourseRepositroy courseRepositroy;

    @Autowired
    public void setCourseRepositroy(CourseRepositroy courseRepositroy) {
        this.courseRepositroy = courseRepositroy;
    }

    public Course save(Course course) {
        return courseRepositroy.save(course);
    }

    @Cacheable(value="c_course")
    public Course findByName(String s) {
        return courseRepositroy.findByName(s);
    }

    public Page<Course> getCourses(int pageNumber, int pageSize) {
        PageRequest request = PageRequest.of(pageNumber,pageSize);
        Page<Course> coursess= this.courseRepositroy.findAll(request);
        return coursess;
    }


}
