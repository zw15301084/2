package com.example.demo.service;

import com.example.demo.domain.Coach;
import com.example.demo.domain.Customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer login(String username, String password);

    Customer getCustomerByNameAndPassword(String username, String password);

    void signUp(Customer customer);

    void save(List<Customer> customers);

    Customer findByname(String username);
}