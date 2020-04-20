package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidOptionException;
import com.twu.biblioteca.interfaces.Option;
import com.twu.biblioteca.options.CheckoutBook;
import com.twu.biblioteca.options.ListOfBooks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuOptions {

    private List<Option> optionsList = new ArrayList<Option>();

    private ListOfBooks listOfBooks = new ListOfBooks();
    private CheckoutBook checkoutBook = new CheckoutBook();

    public MenuOptions(){
        optionsList.add(listOfBooks);
        optionsList.add(checkoutBook);
    }

    public String showMenu(){
        StringBuilder optionListBuilder = new StringBuilder();

        for (Option option : optionsList){
            optionListBuilder.append(option.showOptionName()).append("\n");
        }

        return optionListBuilder.toString();
    }

    public void choseOption(String optionChoose) throws InvalidOptionException{
        if ("1".equals(optionChoose)) {
            System.out.println(listOfBooks.showBookList());
        }
        if ("2".equals(optionChoose)) {
            System.out.println("Fazendo checkout do livre tal");
        }
        throw new InvalidOptionException("Please select a valid option!");
    }
}
