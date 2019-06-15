package com.example.javaee.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import com.example.javaee.demo.domain.Customer;
import com.example.javaee.demo.repository.CustomerRepository;

@Component
public class CustomerServiceImp implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer login(String username, String password) {
        return getCustomerByNameAndPassword(username, password);
    }

    public Customer getCustomerByNameAndPassword(String username, String password) {

        return customerRepository.findByUsernameAndPassword(username, password);
    }

    public void signUp(Customer customer) {
        customerRepository.save(customer);
    }

    public void save(List<Customer> customers) {
        for(Customer customer:customers){
            customerRepository.save(customer);
        }
    }

    public Customer findByname(String username) {
        return customerRepository.findByUsername(username);
    }

    @Override
    public void setpsd(String username, String psd) {
        customerRepository.reset_psd(username,psd);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

}