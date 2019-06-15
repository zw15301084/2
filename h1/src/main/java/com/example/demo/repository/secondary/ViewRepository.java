package com.example.demo.repository.secondary;

import com.example.demo.domain.secondary.ViewLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewRepository extends JpaRepository<ViewLog,Integer> {
}
