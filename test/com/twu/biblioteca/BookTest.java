package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BookTest {

    Book book = new Book ("The Godfather", "Francis Ford Coppola", "1972");

    @Test
    public void toStringBookTest(){
        String bookString = "Title: The Godfather | Author: Francis Ford Coppola | Released Year: 1972";
        assertThat(book.toString(), equalTo(bookString));
    }
}
