package com.example.assignment.service;

import com.example.assignment.entity.Author;
import com.example.assignment.entity.Book;
import com.example.assignment.repository.AuthorRepository;
import com.example.assignment.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {

  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> getBooksByName(String name) {
    return bookRepository.findBooksByName(name);
  }

  public List<Book> getBooksByCreatedDate(LocalDate date) {
    return bookRepository.findBooksByCreatedDate(date);
  }

  public Book createBook(Book book) {
    return bookRepository.save(book);
  }

  public Book updateBook(Integer id, Book author) {
    return bookRepository.save(author);
  }

  public void deleteBook(Integer id) {
    bookRepository.deleteById(id);
  }
}
