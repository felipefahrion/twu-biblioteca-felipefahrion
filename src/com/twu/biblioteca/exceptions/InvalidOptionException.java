package com.twu.biblioteca.exceptions;

import com.twu.biblioteca.interfaces.Option;

public class InvalidOptionException extends Exception {
    public InvalidOptionException(String message){
        super(message);
    }
}
