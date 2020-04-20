package com.twu.biblioteca;

import com.twu.biblioteca.options.CheckoutBook;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class CheckoutBookTest {
    CheckoutBook checkoutBook;

    @Before
    public void setUp(){
        checkoutBook = new CheckoutBook();
    }

    @Test
    public void showOptionNameTest(){
        String checkoutOptionString = "2 - Checkout a book";
        assertThat(checkoutBook.showOptionName(), containsString(checkoutOptionString));
    }
}
