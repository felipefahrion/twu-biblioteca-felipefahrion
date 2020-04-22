package com.twu.biblioteca.options;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.interfaces.Option;
import com.twu.biblioteca.models.Book;

import java.util.List;
import java.util.Scanner;

public class ReturnBook implements Option {

    private List<Book> books;

    public ReturnBook(List<Book> books) {
        this.books = books;
    }

    @Override
    public String showOptionName() {
        return "Return a book";
    }

    @Override
    public void call() {
        System.out.print("Type a book title: ");

        try {
            Book book = findBookByTitle(new Scanner(System.in).nextLine());

            if (book.isCheckedOut()) {
                book.setCheckout(false);
                System.out.println("Thank you for returning the book");
            } else {
                System.out.println("That is not a valid book to return");
            }
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private Book findBookByTitle(String bookTitle) throws BookNotFoundException {
        return books.stream()
                .filter(book -> bookTitle.equals(book.getTitle()))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
    }
}
