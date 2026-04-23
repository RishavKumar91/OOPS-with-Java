package com.example.library.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;

import com.example.library.model.*;
import com.example.library.repository.*;

@Service
public class IssueService {

    private final IssueRepository repo;
    private final BookRepository bookRepo;
    private final UserRepository userRepo;

    public IssueService(IssueRepository repo, BookRepository bookRepo, UserRepository userRepo) {
        this.repo = repo;
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    public Issue issueBook(Issue issue) {

        if (issue.getUser() == null || issue.getBook() == null) {
            throw new RuntimeException("❌ User or Book missing");
        }

        Book book = bookRepo.findById(issue.getBook().getId())
                .orElseThrow(() -> new RuntimeException("❌ Book not found"));

        User user = userRepo.findById(issue.getUser().getId())
                .orElseThrow(() -> new RuntimeException("❌ User not found"));

        if (book.getQuantity() <= 0) {
            throw new RuntimeException("❌ Book out of stock");
        }

        book.setQuantity(book.getQuantity() - 1);
        bookRepo.save(book);

        issue.setBook(book);
        issue.setUser(user);
        issue.setIssueDate(LocalDate.now());
        issue.setReturned(false);

        return repo.save(issue);
    }

    public Issue returnBook(Long id) {

        Issue issue = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("❌ Issue not found"));

        if (issue.isReturned()) {
            throw new RuntimeException("❌ Already returned");
        }

        Book book = issue.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepo.save(book);

        issue.setReturned(true);
        issue.setReturnDate(LocalDate.now());

        return repo.save(issue);
    }
}