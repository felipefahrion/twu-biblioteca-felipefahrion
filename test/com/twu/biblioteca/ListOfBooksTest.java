package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.options.ListOfBooks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class ListOfBooksTest {

    ListOfBooks listOfBooksOption;
    List<Book> books;

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
        books = new ArrayList<Book>();
        listOfBooksOption = new ListOfBooks(books);
    }

    @Test
    public void showOptionNameTest() {
        String listOfBooksString = "List of books";
        assertThat(listOfBooksOption.showOptionName(), is(listOfBooksString));
    }

    @Test
    public void showBookListOnCallTest() {
        String listOfBooksString = "Title: The Godfather | Author: Francis Ford Coppola | Released Year: 1972\n\n";
        books.add(new Book("The Godfather", "Francis Ford Coppola", "1972"));
        listOfBooksOption.call();
        assertThat(outContent.toString(), is(listOfBooksString));
    }

    @Test
    public void showEmptyBookListOnCallTest() {
        String listOfBooksString = "\n";
        listOfBooksOption.call();
        assertThat(outContent.toString(), is(listOfBooksString));
    }
}