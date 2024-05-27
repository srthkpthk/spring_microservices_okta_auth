package com.hotel.userservice.exceptions;

public class InvalidParametersException extends RuntimeException {
    public InvalidParametersException() {
        super("InvalidParametersException");
    }

    public InvalidParametersException(String message) {
        super(message);
    }
}
