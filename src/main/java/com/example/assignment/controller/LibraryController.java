package com.example.assignment.controller;

import com.example.assignment.entity.SubLibrary;
import com.example.assignment.service.SubLibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sub-libraries")
public class LibraryController {

  private final SubLibraryService libraryService;

  public LibraryController(SubLibraryService libraryService) {
    this.libraryService = libraryService;
  }

  @GetMapping
  public List<SubLibrary> getSubLibrariesBySubject(@RequestParam String subject) {
    return libraryService.getSubLibrariesBySubject(subject);
  }

  @PostMapping
  public SubLibrary createSubLibrary(@RequestBody SubLibrary subLibrary) {
    return libraryService.createSubLibrary(subLibrary);
  }

  @PutMapping("/{id}")
  public SubLibrary createSubLibrary(@PathVariable Integer id, @RequestBody SubLibrary subLibrary) {
    return libraryService.updateSubLibrary(id, subLibrary);
  }
}
