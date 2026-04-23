package com.example.library.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.example.library.model.User;
import com.example.library.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User save(User user) {
        return repo.save(user);
    }

    public List<User> getAll() {
        return repo.findAll();
    }
}