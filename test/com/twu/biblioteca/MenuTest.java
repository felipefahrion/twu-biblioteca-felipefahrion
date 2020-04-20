package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidOptionException;
import com.twu.biblioteca.interfaces.Option;
import com.twu.biblioteca.options.ListOfBooks;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    Menu menu;
    LinkedHashMap<String, Option> options = new LinkedHashMap<String, Option>();

    @Before
    public void setUp() {
        menu = new Menu(options);
    }

    @Test
    public void chooseOptionAndExecuteTest() throws InvalidOptionException {
        ListOfBooks listOfBooks = mock(ListOfBooks.class);

        options.put("1", listOfBooks);
        menu.chooseOption("1");
        verify(listOfBooks).call();
    }

    @Test
    public void showFakeOptionMenuTest() {
        String optionFake = "99 - List of books\n";
        options.put("99", new ListOfBooks());
        assertThat(menu.showMenu(), is(optionFake));
    }

    @Test(expected = InvalidOptionException.class)
    public void choseInvalidOptionTest() throws InvalidOptionException {
        String optionChoose = "X";
        menu.chooseOption(optionChoose);
    }
}