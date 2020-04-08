package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        System.out.println(welcomeMessage.initilize());

        System.out.print("\n");

        MenuOptions menuOptions = new MenuOptions();
        System.out.println(menuOptions.showMenu());
    }
}
