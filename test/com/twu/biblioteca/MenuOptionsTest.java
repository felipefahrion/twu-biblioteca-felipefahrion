package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidOptionException;
import com.twu.biblioteca.interfaces.Option;
import com.twu.biblioteca.options.ListOfBooks;
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

    @Test
    public void choseOptionTest() throws InvalidOptionException {
        String optionChoose = "1";
        assertThat(menu.choseOption(optionChoose), is(instanceOf((Option.class))));
    }

    @Test(expected = InvalidOptionException.class)
    public void choseInvalidOptionTest() throws InvalidOptionException {
        String optionChoose = "X";
        menu.choseOption(optionChoose);
    }
}