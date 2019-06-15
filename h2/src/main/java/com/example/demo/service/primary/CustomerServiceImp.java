package com.example.demo.service.primary;

import com.example.demo.domain.primary.Customer;
import com.example.demo.repository.primary.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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

}