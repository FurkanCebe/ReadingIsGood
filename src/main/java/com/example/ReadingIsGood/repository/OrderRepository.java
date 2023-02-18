package com.example.ReadingIsGood.repository;

import com.example.ReadingIsGood.entity.Book;
import com.example.ReadingIsGood.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository
        extends MongoRepository<Order,String> {

    List<Order> findOrdersByOrderId(String orderId);
//    String
    List<Order> findOrdersByCustomerId(String customerId);

}
