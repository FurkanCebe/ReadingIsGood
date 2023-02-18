package com.example.ReadingIsGood.controller;

import com.example.ReadingIsGood.entity.Book;
import com.example.ReadingIsGood.entity.Order;
import com.example.ReadingIsGood.repository.OrderRepository;
import com.example.ReadingIsGood.service.BookService;
import com.example.ReadingIsGood.service.OrderService;
import org.springframework.core.annotation.OrderUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/order/api")
@RestController
public class OrderController {
    private final OrderService orderService;
    private final BookService bookService;

    private final BookController bookController;
    public OrderController(OrderService orderService, BookService bookService, BookController bookController) {
        this.orderService = orderService;
        this.bookService = bookService;
        this.bookController = bookController;
    }

    @PostMapping(path = "/addOrder/{bookId}/{customerId}/{amount}")
    public void addNewOrder(@PathVariable("bookId") String bookId,@PathVariable("customerId") String customerId,@PathVariable("amount") String amountS)
    {
        Integer amount = Integer.parseInt(amountS);
        if(bookService.getBookById(bookId).getStock() < amount || amount <= 0)
        {
            return;
        }
        bookService.removeBook(bookId,amount);
        Order order = new Order();
        order.setAmount(amount);;
        order.setCustomerId(customerId);
        order.setBookId(bookId);
        order.setOrderTime(LocalDateTime.now());
        orderService.addNewOrder(order);
    }

    @GetMapping(path = "/getOrder/{orderId}")
    public Order getOrderById(@PathVariable("orderId") String id)
    {
        return orderService.getOrderById(id);
    }

    @GetMapping(path = "/orderList")
    public List<Order> getOrderList()
    {
        return orderService.getAllOrders();
    }
}
