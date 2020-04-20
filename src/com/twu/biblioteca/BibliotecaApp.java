package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidOptionException;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        System.out.println(welcomeMessage.initilize() + "\n");

        MenuOptions menuOptions = new MenuOptions();

        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println(menuOptions.showMenu());

            try{
                menuOptions.choseOption(in.nextLine());
            } catch (InvalidOptionException ex) {
                System.out.println(ex.getMessage());
            }

            System.out.print("\n");
        }
    }
}