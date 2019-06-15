package com.example.javaee.demo.repository;

import com.example.javaee.demo.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    //@Query(value = "select * from user where username=?1 and password=?2", nativeQuery = true)
    //Customer findByUsernameAndPassword(String username, String password);

    

}