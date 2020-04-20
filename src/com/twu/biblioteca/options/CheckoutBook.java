package com.twu.biblioteca.options;

import com.twu.biblioteca.interfaces.Option;

public class CheckoutBook implements Option {

    @Override
    public String showOptionName() {
        return "2 - Checkout a book";
    }
}
