package com.hotel.ratingservice.exceptions;

public class InvalidParametersException extends RuntimeException {
    public InvalidParametersException() {
        super("InvalidParametersException");
    }

    public InvalidParametersException(String message) {
        super(message);
    }
}
