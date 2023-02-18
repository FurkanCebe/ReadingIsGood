package com.example.ReadingIsGood.service;

import com.example.ReadingIsGood.entity.MonthlyStatistics;
import com.example.ReadingIsGood.entity.Order;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StatisticsService {

    public final OrderService orderService;

    public StatisticsService(OrderService orderService) {
        this.orderService = orderService;
    }

    public List<MonthlyStatistics> getStatistics(String customerId)
    {
        List<Order> orders = orderService.getOrdersByCustomerId(customerId);
        orders.sort(Comparator.comparing(Order::getOrderTime));
        MonthlyStatistics monthly = new MonthlyStatistics();
        List<MonthlyStatistics> statistics = new ArrayList<>();
        if(orders.size()==0)
            return statistics;
        Order firstOrder = orders.get(0);
        String date = String.valueOf(firstOrder.getOrderTime().getMonth()) + " " + String.valueOf(firstOrder.getOrderTime().getYear());
        monthly.setMonth(date);
        monthly.setTotalOrderCount(1);
        monthly.setTotalBookCount(firstOrder.getAmount());

        for(int i = 1; i < orders.size(); i++)
        {
            Order order = orders.get(i);
            String currDate = String.valueOf(order.getOrderTime().getMonth()) + " " + String.valueOf(order.getOrderTime().getYear());
            if(!monthly.getMonth().equals(currDate)) {
                System.out.println(currDate + " " + date);
                statistics.add(monthly);
                monthly.setMonth(currDate);
                monthly.setTotalOrderCount(1);
                monthly.setTotalBookCount(order.getAmount());
            }
            else {
                monthly.setTotalOrderCount(monthly.getTotalOrderCount() + 1);
                monthly.setTotalBookCount(monthly.getTotalBookCount() + order.getAmount());
            }
        }
        statistics.add(monthly);
        return statistics;

    }
}
