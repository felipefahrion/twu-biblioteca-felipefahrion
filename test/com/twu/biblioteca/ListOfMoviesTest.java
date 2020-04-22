package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.options.ListOfBooks;
import com.twu.biblioteca.options.ListOfMovies;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ListOfMoviesTest {
    ListOfMovies listOfMoviesOption;
    List<Movie> movies;

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
        movies = new ArrayList<Movie>();
        listOfMoviesOption = new ListOfMovies(movies);
    }

    @Test
    public void showOptionNameTest() {
        String listOfMoviesString = "List of movies";
        assertThat(listOfMoviesOption.showOptionName(), is(listOfMoviesString));
    }

    @Test
    public void showBookListOnCallTest() {
        String listOfBooksString = "Title: The Godfather | Director: Francis Ford Coppola | Released Year: 1972 | Rating: 9\n\n";

        movies.add(new Movie("The Godfather", "Francis Ford Coppola", "1972", 9));
        listOfMoviesOption.call();

        assertThat(outContent.toString(), is(listOfBooksString));
    }
}
