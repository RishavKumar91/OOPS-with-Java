package com.example.library.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book save(Book book) {
        return repo.save(book);
    }

    public List<Book> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}