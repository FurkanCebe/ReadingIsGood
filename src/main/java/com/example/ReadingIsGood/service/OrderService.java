package com.example.ReadingIsGood.service;

import com.example.ReadingIsGood.entity.Book;
import com.example.ReadingIsGood.entity.Order;
import com.example.ReadingIsGood.repository.BookRepository;
import com.example.ReadingIsGood.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addNewOrder(Order order)
    {
        orderRepository.insert(order);
    }

    public Order getOrderById(String orderId)
    {
        if(orderRepository.findOrdersByOrderId(orderId).size()>0)
            return orderRepository.findOrdersByOrderId(orderId).get(0);
        Order Null = new Order();
        return Null;
    }

    public List<Order> getOrdersByCustomerId(String customerId)
    {
        return orderRepository.findOrdersByCustomerId(customerId);
    }

    public List<Order> getAllOrders()
    {
        return orderRepository.findAll();
    }

}
