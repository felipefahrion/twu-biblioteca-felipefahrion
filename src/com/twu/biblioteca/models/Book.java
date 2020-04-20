package com.twu.biblioteca.models;

public class Book {
    private String title;
    private String author;
    private String releasedYear;
    private boolean checkout;

    public Book(String title, String author, String releasedYear) {
        this.title = title;
        this.author = author;
        this.releasedYear = releasedYear;
        this.checkout = false;
    }

    public Book(String title, String author, String releasedYear, boolean checkout) {
        this.title = title;
        this.author = author;
        this.releasedYear = releasedYear;
        this.checkout = checkout;
    }

    public String getTitle() {
        return title;
    }

    public void setCheckout(boolean checkout) {
        this.checkout = checkout;
    }

    public boolean isCheckedOut() {
        return checkout;
    }

    @Override
    public String toString() {
        return "Title: " + title + " | Author: " + author + " | Released Year: " + releasedYear;
    }
}
