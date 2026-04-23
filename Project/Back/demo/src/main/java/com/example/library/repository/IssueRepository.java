package com.example.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library.model.Issue;
import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByUserId(Long id);
    List<Issue> findByUserIdAndReturnedFalse(Long id);
}