package com.twu.biblioteca;

import com.twu.biblioteca.models.Book;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BookTest {

    Book book = new Book ("The Godfather", "Francis Ford Coppola", "1972");
    Book book2 = new Book("Pulp Fiction", "Quentin Tarantino", "1994", true);

    @Test
    public void toStringBookChekoutFalseTest(){
        String bookString = "Title: The Godfather | Author: Francis Ford Coppola | Released Year: 1972";
        assertThat(book.toString(), equalTo(bookString));
    }

    @Test
    public void toStringBookCheckoutTrueTest(){
        String bookString = "Title: Pulp Fiction | Author: Quentin Tarantino | Released Year: 1994";
        assertThat(book2.toString(), equalTo(bookString));
    }
}
