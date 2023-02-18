package com.example.ReadingIsGood.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Customer
{
    @Id
    String id;
    String firstName;
    String secondName;

    String email;
}
