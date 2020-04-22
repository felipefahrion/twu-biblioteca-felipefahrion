package com.twu.biblioteca.models;

public class Movie {
    private String title;
    private String director;
    private String releasedYear;
    private int rating;
    private boolean checkout;

    public Movie(String title, String director, String releasedYear, int rating) {
        this.title = title;
        this.director = director;
        this.releasedYear = releasedYear;
        this.rating = rating;
        this.checkout = false;
    }

    public Movie(String title, String director, String releasedYear, int rating, boolean checkout) {
        this.title = title;
        this.director = director;
        this.releasedYear = releasedYear;
        this.rating = rating;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Title: " + title + " | Director: " + director + " | Released Year: " + releasedYear + " | Rating: " + rating;
    }

    public boolean isCheckedOut() {
        return checkout;
    }
}
