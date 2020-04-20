package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidOptionException;
import com.twu.biblioteca.interfaces.Option;
import com.twu.biblioteca.options.CheckoutBook;
import com.twu.biblioteca.options.ListOfBooks;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        System.out.println(welcomeMessage.initilize() + "\n");

        LinkedHashMap<String, Option> options = new LinkedHashMap<String, Option>();
        options.put("1", new ListOfBooks());
        options.put("2", new CheckoutBook());

        Menu menuOptions = new Menu(options);

        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println(menuOptions.showMenu());

            try{
                menuOptions.chooseOption(in.nextLine());
            } catch (InvalidOptionException ex) {
                System.out.println(ex.getMessage());
            }

            System.out.print("\n");
        }
    }
}