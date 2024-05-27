package com.hotel.userservice.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("ResourceNotFoundException");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
