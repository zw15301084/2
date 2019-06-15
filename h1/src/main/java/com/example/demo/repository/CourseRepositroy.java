package com.example.demo.repository;

import com.example.demo.domain.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepositroy extends PagingAndSortingRepository<Course, Integer> {

    @Query(value = "select * from course where coursename=?1", nativeQuery = true)
    Course findByName(String s);
}
