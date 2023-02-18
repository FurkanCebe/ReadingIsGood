package com.example.ReadingIsGood.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class Order {
    @Id
    String orderId;

    String bookId;
    String customerId;

    Integer amount;

    LocalDateTime orderTime;


}
