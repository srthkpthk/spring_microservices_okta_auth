package com.hotel.hotelservice.exceptions;

public class InvalidParametersException extends RuntimeException {
    public InvalidParametersException() {
        super("InvalidParametersException");
    }

    public InvalidParametersException(String message) {
        super(message);
    }
}
