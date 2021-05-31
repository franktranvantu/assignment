package com.example.assignment.service;

import com.example.assignment.entity.Author;
import com.example.assignment.entity.Book;
import com.example.assignment.entity.SubLibrary;
import com.example.assignment.repository.AuthorRepository;
import com.example.assignment.repository.BookRepository;
import com.example.assignment.repository.SubLibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthorService {

  private final AuthorRepository authorRepository;
  private final SubLibraryRepository libraryRepository;
  private final BookRepository bookRepository;

  public AuthorService(AuthorRepository authorRepository, SubLibraryRepository libraryRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.libraryRepository = libraryRepository;
    this.bookRepository = bookRepository;
  }

  public List<Author> getAllAuthors() {
    return authorRepository.findAll();
  }

  public List<Author> getAuthorsByName(String name) {
    return authorRepository.findAuthorByNameOrderByCreationDesc(name);
  }

  public List<Author> getAuthorsByAcademicCredentials(String academicCredentials) {
    return authorRepository.findAuthorByAcademicCredentials(academicCredentials);
  }

  public Author createAuthor(Author author) {
    SubLibrary subLibrary = libraryRepository.findById(author.getSubLibrary().getId()).orElseThrow(() -> new IllegalArgumentException("Sub Library not found"));
    Set<Book> books = author.getBooks().stream()
        .map(book -> bookRepository.findById(book.getId()).orElseThrow(() -> new IllegalArgumentException("Book not found")))
        .collect(Collectors.toSet());
    author.setSubLibrary(subLibrary);
    author.setBooks(books);
    return authorRepository.save(author);
  }

  public Author updateAuthor(Integer id, Author author) {
    return authorRepository.save(author);
  }

  public void deleteAuthor(Integer id) {
    authorRepository.deleteById(id);
  }

}
