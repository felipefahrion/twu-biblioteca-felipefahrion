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
        assertThat(menu.showMenu(), instanceOf(String.class));
    }

    @Test(expected = InvalidOptionException.class)
    public void choseInvalidOptionTest() throws InvalidOptionException {
        String optionChoose = "X";
        menu.choseOption(optionChoose);
    }
}