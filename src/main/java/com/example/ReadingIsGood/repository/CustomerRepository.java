package com.example.ReadingIsGood.repository;

import com.example.ReadingIsGood.entity.Customer;
import com.example.ReadingIsGood.entity.Order;
import com.example.ReadingIsGood.service.CustomerService;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository
        extends MongoRepository<Customer,String> {

    List<Customer> findCustomersById(String customerId);
    List<Customer> findCustomersByEmail(String email);
}
