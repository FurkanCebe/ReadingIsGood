package com.example.ReadingIsGood.service;

import com.example.ReadingIsGood.entity.Customer;
import com.example.ReadingIsGood.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer)
    {
        if(customerRepository.findCustomersByEmail(customer.getEmail()).size()>0)
            return;
        customerRepository.insert(customer);
    }
    public List<Customer> findCustomersByEmail(String email)
    {
        return customerRepository.findCustomersByEmail(email);
    }
}
