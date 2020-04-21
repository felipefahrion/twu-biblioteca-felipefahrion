package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.options.CheckoutBook;
import com.twu.biblioteca.options.ListOfBooks;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class CheckoutBookTest {
    CheckoutBook checkoutBook;

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
        checkoutBook = new CheckoutBook(books);
    }

    @Test
    public void showOptionNameTest() {
        String checkoutOptionString = "Checkout a book";
        assertThat(checkoutBook.showOptionName(), is(checkoutOptionString));
    }

    @Test
    public void checkoutBookOnCallTest() {
        Book book = new Book("The Godfather", "Francis Ford Coppola", "1972");
        books.add(book);

        String input = "The Godfather";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        checkoutBook.call();
        assertThat(book.isCheckedOut(), is(true));
    }

    @Test
    public void checkoutInvalidBookOnCallTest() {
        String input = "The Godfather";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        checkoutBook.call();
        assertThat(outContent.toString(), containsString("Book not found"));
    }

    @Test
    public void successMessageOnCheckoutABookTest() {
        Book book = new Book("The Godfather", "Francis Ford Coppola", "1972");
        books.add(book);

        String input = "The Godfather";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        checkoutBook.call();
        assertThat(outContent.toString(), containsString("Thank you! Enjoy the book"));
    }

    @Test
    public void failureMessageOnCheckoutABookTest() {
        Book book = new Book("The Godfather", "Francis Ford Coppola", "1972", true);
        books.add(book);

        String input = "The Godfather";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        checkoutBook.call();
        assertThat(outContent.toString(), containsString("Sorry, that book is not available"));
    }

//    @Test
//    public void checkoutedBookOnCallTest() {
//        Book book = new Book("The Godfather", "Francis Ford Coppola", "1972");
//        books.add(book);
//
//        String input = "The Godfather";
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        checkoutBook.call();
//        assertThat(book.isCheckedOut(), is(true));
//    }
}
