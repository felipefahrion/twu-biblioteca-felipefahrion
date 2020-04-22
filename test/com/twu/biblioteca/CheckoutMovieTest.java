package com.twu.biblioteca;

import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.options.CheckoutMovie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CheckoutMovieTest {
    CheckoutMovie checkoutMovie;

    List<Movie> movies = new ArrayList<Movie>();

    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void revertStreams() {
        System.setOut(sysOut);
    }

    @Before
    public void setUp() {
        checkoutMovie = new CheckoutMovie(movies);
    }

    @Test
    public void showOptionNameTest() {
        String checkoutOptionString = "Checkout a movie";
        assertThat(checkoutMovie.showOptionName(), is(checkoutOptionString));
    }

    @Test
    public void checkoutBookOnCallTest() {
        Movie movie = new Movie("The Godfather", "Francis Ford Coppola", "1972", 9);
        movies.add(movie);

        String input = "The Godfather";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        checkoutMovie.call();
        assertThat(movie.isCheckedOut(), is(true));
    }

    @Test
    public void checkoutInvalidMovieOnCallTest() {
        String input = "The Godfather";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        checkoutMovie.call();
        assertThat(outContent.toString(), containsString("Movie not found"));
    }

    @Test
    public void successMessageOnCheckoutABookTest() {
        Movie movie = new Movie("The Godfather", "Francis Ford Coppola", "1972", 9);
        movies.add(movie);

        String input = "The Godfather";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        checkoutMovie.call();
        assertThat(outContent.toString(), containsString("Thank you! Enjoy the movie"));
    }

    @Test
    public void failureMessageOnCheckoutABookTest() {
        Movie movie = new Movie("The Godfather", "Francis Ford Coppola", "1972", 9, true);
        movies.add(movie);

        String input = "The Godfather";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        checkoutMovie.call();
        assertThat(outContent.toString(), containsString("Sorry, that movie is not available"));
    }
}
