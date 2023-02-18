package com.example.ReadingIsGood.controller;

import com.example.ReadingIsGood.entity.Customer;
import com.example.ReadingIsGood.entity.Order;
import com.example.ReadingIsGood.service.CustomerService;
import com.example.ReadingIsGood.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("customer/api")
public class CustomerController {

    public final CustomerService customerService;

    public final OrderService orderService;

    public CustomerController(CustomerService customerService, OrderService orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @PostMapping(path = "/register")
    public void registerCustomer(@RequestBody Customer customer)
    {
        customerService.addCustomer(customer);
    }

    @GetMapping(path = "/orders/{customerId}")
    public List<Order> getOrdersOfCustomer(@PathVariable("customerId") String customerID)
    {
        return orderService.getOrdersByCustomerId(customerID);
    }



}
