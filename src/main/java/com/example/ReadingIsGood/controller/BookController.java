package com.example.ReadingIsGood.controller;

import com.example.ReadingIsGood.entity.Book;
import com.example.ReadingIsGood.service.BookService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/book/api")
@RestController

public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping(path = "/addBook")
    public void addBook(Book book)
    {
        bookService.addBook(book);
    }

    @GetMapping(path = "/getBook/{bookId}")
    public Book getBookById(@PathVariable("bookId") String id)
    {
        return bookService.getBookById(id);
    }
    @GetMapping (path = "/getBookId/{bookName}")

    public String getBookIdByBookName(@PathVariable("bookName") String name)
    {
        return bookService.getBookIdByBookName(name);
    }

    @PatchMapping(path = "/removeBook/{bookId}/{amount}")
    public void removeBook(@PathVariable("bookId") String id, @PathVariable("amount") String amountS)
    {
        Integer amount =Integer.parseInt(amountS);
        bookService.removeBook(id,amount);
    }

    @GetMapping (path = "/bookList")
    public List<Book> getBookList()
    {
        return bookService.getBooks();
    }




}
