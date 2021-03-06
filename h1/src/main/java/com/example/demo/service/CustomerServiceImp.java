package com.example.demo.service;

import com.example.demo.domain.Coach;
import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerServiceImp implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer login(String username, String password) {
        return getCustomerByNameAndPassword(username, password);
    }

    @Override
    public Customer getCustomerByNameAndPassword(String username, String password) {

        return customerRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void signUp(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void save(List<Customer> customers) {
        for(Customer customer:customers){
            customerRepository.save(customer);
        }
    }

    @Override
    public Customer findByname(String username) {
        return customerRepository.findByUsername(username);
    }

}