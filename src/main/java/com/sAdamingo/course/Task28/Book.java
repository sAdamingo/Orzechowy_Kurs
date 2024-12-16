package com.sAdamingo.course.Task28;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Book {
    private int id;
    private String author;
    private String title;
    private final Timestamp createdOn;

    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.createdOn = Timestamp.valueOf(LocalDateTime.now());
    }

    public Book(int id, String author, String title, Timestamp createdOn) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Book with id: " + id + " was written by: " + author + " and its title is " + title + ". Position created on " + createdOn.toString();
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
