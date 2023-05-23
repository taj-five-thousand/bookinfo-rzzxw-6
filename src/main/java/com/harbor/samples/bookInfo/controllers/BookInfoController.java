package com.harbor.samples.bookInfo.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harbor.samples.bookInfo.models.Book;
import com.harbor.samples.bookInfo.services.BookService;

@RestController
public class BookInfoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookInfoController.class);

    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public Book createBook(Book book) {
        LOGGER.info("Creating book: {}", book);
        return bookService.createBook(book);
    }

    @GetMapping("/book/{id}")
    public Book getBookById(Long id) {
        LOGGER.info("Getting book with id: {}", id);
        return bookService.getBookById(id);
    }

    @PutMapping("/book/{id}")
    public Book updateBook(Book book) {
        LOGGER.info("Updating book: {}", book);
        return bookService.updateBook(book);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(Long id) {
        LOGGER.info("Deleting book with id: {}", id);
        bookService.deleteBook(id);
    }

    @GetMapping("/getBookByName")
    public List<Book> getBookByName(@RequestParam("bookName") String name) {
        LOGGER.info("Getting book with name: {}", name);
        return bookService.getBookByName(name);
    }

}
