package com.example.ReadingIsGood.controller;

import com.example.ReadingIsGood.entity.MonthlyStatistics;
import com.example.ReadingIsGood.service.StatisticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    public final OrderController orderController;
    public final StatisticsService statisticsService;
    public StatisticsController(OrderController orderController, StatisticsService statisticsService) {
        this.orderController = orderController;
        this.statisticsService = statisticsService;
    }

    @GetMapping("/customerStatistics/{customerId}")
    public List<MonthlyStatistics> getStatistcs(@PathVariable("customerId") String customerId)
    {
        return statisticsService.getStatistics(customerId);
    }
//    public
}
