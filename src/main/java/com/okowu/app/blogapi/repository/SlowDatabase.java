package com.okowu.app.blogapi.repository;

import com.okowu.app.blogapi.model.Article;
import com.okowu.app.blogapi.model.Author;
import com.okowu.app.blogapi.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SlowDatabase {

    private final Map<Long, Article> articles = new HashMap<>();
    private final Map<Long, Author> authors = new HashMap<>();
    private final Map<Long, Integer> comments = new HashMap<>();

    public SlowDatabase() {
        articles.put(1L, new Article(1L, "Intro to Redis",
                "Redis is an in-memory data structure store...", 101L));
        articles.put(2L, new Article(2L, "Java Async Programming",
                "Asynchronous programming in Java...", 102L));
        articles.put(3L, new Article(3L, "Spring Boot Best Practices",
                "Building production-ready applications...", 101L));
        articles.put(4L, new Article(4L, "Microservices Patterns",
                "Design patterns for distributed systems...", 103L));
        articles.put(5L, new Article(5L, "Database Optimization",
                "Techniques for improving query performance...", 102L));

        authors.put(101L, new Author(101L, "Alice Smith", "Senior Software Engineer"));
        authors.put(102L, new Author(102L, "Bob Johnson", "DevOps Specialist"));
        authors.put(103L, new Author(103L, "Carol White", "System Architect"));

        comments.put(1L, 45);
        comments.put(2L, 23);
        comments.put(3L, 67);
        comments.put(4L, 12);
        comments.put(5L, 89);
    }

    public Article getArticle(Long articleId) {
        simulateLatency(50);
        return articles.get(articleId);
    }

    public Author getAuthor(Long authorId) {
        simulateLatency(30);
        return authors.get(authorId);
    }

    public Integer getCommentCount(Long articleId) {
        simulateLatency(20);
        return comments.getOrDefault(articleId, 0);
    }

    private void simulateLatency(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Sleep interrupted", e);
        }
    }
}
