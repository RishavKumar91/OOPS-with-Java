package com.example.library.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.library.model.Issue;
import com.example.library.service.IssueService;
import com.example.library.repository.IssueRepository;

@RestController
@RequestMapping("/issue")
@CrossOrigin(origins = "http://localhost:3000")
public class IssueController {

    private final IssueService service;
    private final IssueRepository repo;

    public IssueController(IssueService service, IssueRepository repo) {
        this.service = service;
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<?> issueBook(@RequestBody Issue issue) {
        try {
            System.out.println("Incoming Issue: " + issue); // debug
            return ResponseEntity.ok(service.issueBook(issue));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/return/{id}")
    public ResponseEntity<?> returnBook(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.returnBook(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/user/{id}")
    public List<Issue> getByUser(@PathVariable Long id) {
        return repo.findByUserId(id);
    }

    @GetMapping("/active/{id}")
    public List<Issue> getActive(@PathVariable Long id) {
        return repo.findByUserIdAndReturnedFalse(id);
    }
}