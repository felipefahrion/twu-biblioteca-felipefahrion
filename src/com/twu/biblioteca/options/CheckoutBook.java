package com.twu.biblioteca.options;

import com.twu.biblioteca.exceptions.BookNotFoundException;
import com.twu.biblioteca.interfaces.Option;
import com.twu.biblioteca.models.Book;

import java.util.List;
import java.util.Scanner;

public class CheckoutBook implements Option {

    private List<Book> books;

    public CheckoutBook(List<Book> books) {
        this.books = books;
    }

    @Override
    public String showOptionName() {
        return "Checkout a book";
    }

    @Override
    public void call() {
        System.out.print("Type a book title: ");

        try {
            Book book = findBookByTitle(new Scanner(System.in).nextLine());

            if (!book.isCheckedOut()) {
                book.setCheckout(true);
                System.out.println("Thank you! Enjoy the book");
            }
            System.out.println("Sorry, that book is not available");
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
