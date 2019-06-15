package com.example.demo.repository.primary;

import com.example.demo.domain.primary.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where username=?1 and password=?2", nativeQuery = true)
    Customer findByUsernameAndPassword(String username, String password);

    @Query(value = "select * from customer where username=?1", nativeQuery = true)
    Customer findByUsername(String username);

}