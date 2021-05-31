package com.example.assignment.repository;


import com.example.assignment.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

  @Query("SELECT a FROM Author a WHERE a.name LIKE %?1% ORDER BY a.name ASC")
  List<Author> findAuthorByNameOrderByCreationDesc(String name);

  @Query("SELECT a FROM Author a " +
         "WHERE a.academicCredentials LIKE %?1% " +
         "ORDER BY a.academicCredentials ASC")
  List<Author> findAuthorByAcademicCredentials(String academicCredentials);

}
