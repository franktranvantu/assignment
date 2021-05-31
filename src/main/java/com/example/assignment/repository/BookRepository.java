package com.example.assignment.repository;


import com.example.assignment.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

  @Query("SELECT b FROM Book b WHERE b.name LIKE %?1% ORDER BY b.name ASC")
  List<Book> findBooksByName(String name);

  @Query("SELECT b FROM Book b WHERE b.creation = ?1 ORDER BY b.creation DESC")
  List<Book> findBooksByCreatedDate(LocalDate createdDate);
}
