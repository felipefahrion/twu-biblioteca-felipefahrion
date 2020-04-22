package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.options.ReturnBook;
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

public class ReturnBookTest {

    private ReturnBook returnBook;
    List<Book> books = new ArrayList<Book>();

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
        returnBook = new ReturnBook(books);
    }

    @Test
    public void showOptionNameTest() {
        String returnABookString = "Return a book";
        assertThat(returnBook.showOptionName(), is(returnABookString));
    }

    @Test
    public void returnBookOnCallTest() {
        Book book = new Book("The Godfather", "Francis Ford Coppola", "1972", true);
        books.add(book);

        String input = "The Godfather";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        returnBook.call();
        assertThat(book.isCheckedOut(), is(false));
    }

    @Test
    public void returnInvalidBookOnCallTest() {
        String input = "The Godfather";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        returnBook.call();
        assertThat(outContent.toString(), containsString("Book not found"));
    }

    @Test
    public void successMessageOnReturnABookTest() {
        Book book = new Book("The Godfather", "Francis Ford Coppola", "1972", true);
        books.add(book);

        String input = "The Godfather";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        returnBook.call();
        assertThat(outContent.toString(), containsString("Thank you for returning the book"));
    }

    @Test
    public void failureMessageOnReturnABookTest() {
        Book book = new Book("The Godfather", "Francis Ford Coppola", "1972");
        books.add(book);

        String input = "The Godfather";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        returnBook.call();
        assertThat(outContent.toString(), containsString("That is not a valid book to return"));
    }
}
