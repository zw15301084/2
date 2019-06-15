package com.example.demo.repository.primary;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.primary.Coach;

@Repository
public interface CoachRepository extends PagingAndSortingRepository<Coach, Integer> {

    @Query(value = "select * from coach where username=?1 and password=?2", nativeQuery = true)
    Coach findByUsernameAndPassword(String username, String password);

    @Query(value = "select * from coach_recom",nativeQuery = true)
    List<Coach> getRecomCoach();
}