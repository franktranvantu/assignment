package com.example.assignment.controller;

import com.example.assignment.entity.Book;
import com.example.assignment.service.BookService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

  private final BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/name")
  public List<Book> getBooksByName(@RequestParam String name) {
    return bookService.getBooksByName(name);
  }

  @GetMapping("/created-date")
  public List<Book> getBooksByName(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate date) {
    return bookService.getBooksByCreatedDate(date);
  }

  @PostMapping
  public Book createBook(@RequestBody Book book) {
    return bookService.createBook(book);
  }

  @PutMapping("/{id}")
  public Book createBook(@PathVariable Integer id, @RequestBody Book book) {
    return bookService.updateBook(id, book);
  }

  @DeleteMapping("/{id}")
  public void deleteBook(@PathVariable Integer id) {
    bookService.deleteBook(id);
  }
}
