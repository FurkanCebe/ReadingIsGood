package com.example.ReadingIsGood.repository;

import com.example.ReadingIsGood.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository
        extends MongoRepository<Book,String> {

    List<Book> findBooksByIdOrName(String id, String name);
    List<Book> findBooksByName(String name);
    List<Book> findBooksById(String id);
}
