package com.twu.biblioteca.models;

public class Book {
    private String title;
    private String author;
    private String releasedYear;

    public Book(String title, String author, String releasedYear) {
        this.title = title;
        this.author = author;
        this.releasedYear = releasedYear;
    }

    @Override
    public String toString() {
        return "Title: " + title + " | Author: " + author + " | Released Year: " + releasedYear;
    }
}
