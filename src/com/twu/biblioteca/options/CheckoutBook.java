package com.twu.biblioteca.options;

import com.twu.biblioteca.interfaces.Option;

public class CheckoutBook implements Option {

    @Override
    public String showOptionName() {
        return "Checkout a book";
    }

    @Override
    public void call() {
    }

}
