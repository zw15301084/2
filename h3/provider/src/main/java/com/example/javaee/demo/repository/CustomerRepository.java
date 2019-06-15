package com.example.javaee.demo.repository;

import com.example.javaee.demo.domain.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from user where username=?1 and password=?2", nativeQuery = true)
    Customer findByUsernameAndPassword(String username, String password);

    @Query(value = "select * from user where username=?1", nativeQuery = true)
    Customer findByUsername(String username);

    @Query(value = "update user set psd=?2 where username=?1", nativeQuery = true)
	void reset_psd(String username,String psd);

}