package com.example.library.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.library.model.Book;
import com.example.library.service.BookService;

@RestController
@RequestMapping("/books")
@CrossOrigin
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.save(book);
    }

    @GetMapping
    public List<Book> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}