package com.example.demo.service.primary;

import com.example.demo.domain.primary.Customer;

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