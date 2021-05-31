package com.example.assignment.repository;


import com.example.assignment.entity.SubLibrary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubLibraryRepository extends JpaRepository<SubLibrary, Integer> {

  @Query("SELECT l FROM SubLibrary l WHERE l.subject LIKE %?1% ORDER BY l.subject ASC")
  List<SubLibrary> findSubLibrariesBySubject(String subject);
}
