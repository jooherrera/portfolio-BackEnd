package com.joseherrera.Backend.exception;

public class EmailExistsException extends Exception {

    public EmailExistsException(String message) {
        super(message);
    }

}
