package com.example.ReadingIsGood.entity;

import lombok.Data;

@Data
public class MonthlyStatistics {
    String month;
    Integer TotalOrderCount;
    Integer TotalBookCount;
}
