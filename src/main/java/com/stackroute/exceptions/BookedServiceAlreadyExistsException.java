package com.stackroute.exceptions;

public class BookedServiceAlreadyExistsException extends Exception {
    String message;

    public BookedServiceAlreadyExistsException() {
    }

    public BookedServiceAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
