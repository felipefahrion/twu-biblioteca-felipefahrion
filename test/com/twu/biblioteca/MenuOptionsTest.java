package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidOptionException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class MenuOptionsTest {

    MenuOptions menu;

    @Before
    public void setUo(){
        menu = new MenuOptions();
    }

    @Test
    public void showMenuTest(){
        String stringTest = "List of books";
        assertThat(menu.listOfBooks.showOptionName(), is(equalTo(stringTest)));
    }

//    @Test
//    public void choseOptionTest() throws InvalidOptionException {
//        String optionChoose = "1";
//        String bookString = "Title: The Godfather | Author: Francis Ford Coppola | Released Year: 1972";
//        assertThat(menu.choseOption(optionChoose), containsString(bookString));
//    }

    @Test(expected = InvalidOptionException.class)
    public void choseInvalidOptionTest() throws InvalidOptionException {
        String optionChoose = "X";
        menu.choseOption(optionChoose);
    }
}