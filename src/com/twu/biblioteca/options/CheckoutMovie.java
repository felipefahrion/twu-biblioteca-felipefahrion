package com.twu.biblioteca.options;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.interfaces.Option;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;

import java.util.List;
import java.util.Scanner;

public class CheckoutMovie implements Option {

    private List<Movie> movies;

    public CheckoutMovie(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String showOptionName() {
        return "Checkout a movie";
    }

    @Override
    public void call() {
        System.out.print("Type a book title: ");

        try {
            Movie movie = findMovieByTitle(new Scanner(System.in).nextLine());

            if (!movie.isCheckedOut()) {
                movie.setCheckout(true);
                System.out.println("Thank you! Enjoy the movie");
            } else {
                System.out.println("Sorry, that movie is not available");
            }
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private Movie findMovieByTitle(String movieTitle) throws BookNotFoundException {
        return movies.stream()
                .filter(movie -> movieTitle.equals(movie.getTitle()))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Movie not found"));
    }
}
