package com.twu.biblioteca.options;


import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.interfaces.Option;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfBooks implements Option {

    private List<Book> books;

    public ListOfBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String showOptionName() {
        return "List of books";
    }

    @Override
    public void call() {
        System.out.println(showBookList());
    }

    private String showBookList() {
        StringBuilder bookListBuilder = new StringBuilder();

        for (Book book : books) {
            if (!book.isCheckedOut()) {
                bookListBuilder.append(book.toString()).append("\n");
            }
        }

        return bookListBuilder.toString();
    }
}