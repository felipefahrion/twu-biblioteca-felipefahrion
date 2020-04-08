package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidOptionException;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        System.out.println(welcomeMessage.initilize());

        System.out.print("\n");

        MenuOptions menuOptions = new MenuOptions();
        System.out.println(menuOptions.showMenu());

        System.out.print("\n");

        try{
            menuOptions.choseOption("X");
        } catch (InvalidOptionException ex) {
            System.out.println(ex.getMessage());
        }
    }
}