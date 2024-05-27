package com.hotel.hotelservice.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("ResourceNotFoundException");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
