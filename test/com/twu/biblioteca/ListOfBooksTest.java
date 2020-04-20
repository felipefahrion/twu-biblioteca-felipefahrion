package com.twu.biblioteca;

import com.twu.biblioteca.options.ListOfBooks;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class ListOfBooksTest {

    ListOfBooks listOfBooksOption;

    @Before
    public void setUp(){
        listOfBooksOption = new ListOfBooks();
    }

    @Test
    public void showOptionNameTest(){
        assertThat(listOfBooksOption.showOptionName(), is(instanceOf(String.class)));
    }

    @Test
    public void showListOfBooksTest(){
        String bookString = "Title: The Godfather | Author: Francis Ford Coppola | Released Year: 1972";
        assertThat(listOfBooksOption.showBookList(), containsString(bookString));
    }

}