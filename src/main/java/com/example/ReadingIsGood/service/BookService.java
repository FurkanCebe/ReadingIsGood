package com.example.ReadingIsGood.service;

import com.example.ReadingIsGood.entity.Book;
import com.example.ReadingIsGood.repository.BookRepository;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book)
    {
        List<Book> bookList = bookRepository.findBooksByIdOrName(book.getId(), book.getName());
        System.out.println(book.getStock());
        if(bookList.size() > 0)
        {
            Book currentBook = bookList.get(0);
            currentBook.setStock(book.getStock() + currentBook.getStock());
            bookRepository.save(currentBook);
        }
        else
        {
            bookRepository.insert(book);
        }
    }
    public Book getBookById(String bookId)
    {
        if(bookRepository.findBooksById(bookId).size()>0)
            return bookRepository.findBooksById(bookId).get(0);
        Book Null = new Book();
        return Null;

    }
    public String getBookIdByBookName(String name)
    {
        List<Book> bookList = bookRepository.findBooksByName(name);
        if(bookList.size() < 0)
            return "";
        return bookList.get(0).getId();
    }
    public Book getBookByName(String name)
    {
        if(bookRepository.findBooksByName(name).size()>0)
            return bookRepository.findBooksByName(name).get(0);
        Book Null = new Book();
        return Null;

    }

    public void removeBook(String id,Integer amount)
    {
        Book book = getBookById(id);
        if(book.getStock()<amount)
            return;
        book.setStock(book.getStock() - amount);
        bookRepository.save(book);
    }

    public List<Book> getBooks()
    {
        return bookRepository.findAll();
    }

}
