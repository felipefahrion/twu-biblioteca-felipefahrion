package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {
    @Test
    public void initilizeBibliotecaTest() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.initilize();


        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore", biblioteca.initilize());
    }
}
