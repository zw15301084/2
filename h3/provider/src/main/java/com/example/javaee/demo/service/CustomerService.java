package com.example.javaee.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.example.javaee.demo.domain.Customer;

@Service
public interface CustomerService {
    Customer login(String username, String password);

    Customer getCustomerByNameAndPassword(String username, String password);

    void signUp(Customer customer);

    void save(List<Customer> customers);

    Customer findByname(String username);

    void setpsd(String username,String psd);

    List<Customer> getAll();
}