package com.example.ReadingIsGood.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Book {
    @Id
    String id;
    String name;
    String author;

    Integer stock;
}
