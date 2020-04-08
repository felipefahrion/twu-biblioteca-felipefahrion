package com.twu.biblioteca;

import com.twu.biblioteca.options.ListOfBooks;

public class MenuOptions {
    public ListOfBooks listOfBooks = new ListOfBooks();

    public String showMenu(){
        return listOfBooks.showOptionName();
    }
}
