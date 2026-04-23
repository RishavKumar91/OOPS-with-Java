package com.example.library.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.library.model.User;
import com.example.library.repository.UserRepository;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return repo.save(user);
    }

    @GetMapping
    public List<User> getAll() {
        return repo.findAll();
    }

    // 🔥 LOGIN
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User dbUser = repo.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!dbUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }

        return dbUser;
    }
}