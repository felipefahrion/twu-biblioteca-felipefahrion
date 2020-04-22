package com.twu.biblioteca.options;

import com.twu.biblioteca.interfaces.Option;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;

import java.util.List;

public class ListOfMovies implements Option {

    private List<Movie> movies;

    public ListOfMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String showOptionName() {
        return "List of movies";
    }

    @Override
    public void call() {
        System.out.println(showListOfMovies());
    }

    private String showListOfMovies() {
        StringBuilder movieListBuilder = new StringBuilder();

        for (Movie movie : movies) {
            if (!movie.isCheckedOut()) {
                movieListBuilder.append(movie.toString()).append("\n");
            }
        }

        return movieListBuilder.toString();
    }
}
