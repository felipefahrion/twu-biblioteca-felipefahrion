package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WelcomeMessageTest {
    @Test
    public void initilizeBibliotecaTest() {
        assertThat("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore", is(new WelcomeMessage().initilize()));
    }
}
