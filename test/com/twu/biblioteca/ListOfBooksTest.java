package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.options.ListOfBooks;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class ListOfBooksTest {

    ListOfBooks listOfBooksOption;

    @Before
    public void setUp(){
        listOfBooksOption = new ListOfBooks();
    }

    @Test
    public void showOptionNameTest(){
        String listOfBooksString = "1 - List of books";
        assertThat(listOfBooksOption.showOptionName(), containsString(listOfBooksString));
    }

    @Test
    public void showListOfBooksTest(){
        String bookString = "Title: The Godfather | Author: Francis Ford Coppola | Released Year: 1972";
        assertThat(listOfBooksOption.showBookList(), containsString(bookString));
    }

    @Test
    public void showListOfBooksWithCheckedOutTest(){
        String bookString = "Title: The Empire Strikes Back | Author: Irvin Kershner | Released Year: 1980";
        assertThat(listOfBooksOption.showBookList(), not(containsString(bookString)));
    }

}