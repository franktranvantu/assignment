package com.example.assignment.controller;

import com.example.assignment.entity.Author;
import com.example.assignment.service.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

  private final AuthorService authorService;

  public AuthorController(AuthorService authorService) {
    this.authorService = authorService;
  }

  @GetMapping
  public List<Author> getAllAuthors() {
    return authorService.getAllAuthors();
  }

  @GetMapping("/name")
  public List<Author> getAuthorsByName(@RequestParam String name) {
    return authorService.getAuthorsByName(name);
  }

  @GetMapping("/academicCredentials")
  public List<Author> getAuthorsByAcademicCredentials(@RequestParam String academicCredentials) {
    return authorService.getAuthorsByAcademicCredentials(academicCredentials);
  }

  @PostMapping
  public Author createAuthor(@RequestBody Author author) {
    return authorService.createAuthor(author);
  }

  @PutMapping("/{id}")
  public Author createAuthor(@PathVariable Integer id, @RequestBody Author author) {
    return authorService.updateAuthor(id, author);
  }

  @DeleteMapping("/{id}")
  public void deleteAuthor(@PathVariable Integer id) {
    authorService.deleteAuthor(id);
  }
}
