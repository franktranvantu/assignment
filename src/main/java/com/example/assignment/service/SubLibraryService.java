package com.example.assignment.service;

import com.example.assignment.entity.SubLibrary;
import com.example.assignment.repository.SubLibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubLibraryService {

  private final SubLibraryRepository libraryRepository;

  public SubLibraryService(SubLibraryRepository libraryRepository) {
    this.libraryRepository = libraryRepository;
  }

  public List<SubLibrary> getSubLibrariesBySubject(String subject) {
    return libraryRepository.findSubLibrariesBySubject(subject);
  }

  public SubLibrary createSubLibrary(SubLibrary subLibrary) {
    return libraryRepository.save(subLibrary);
  }

  public SubLibrary updateSubLibrary(Integer id, SubLibrary subLibrary) {
    return libraryRepository.save(subLibrary);
  }

}
