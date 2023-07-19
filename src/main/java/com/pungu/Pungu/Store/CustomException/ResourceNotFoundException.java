package com.pungu.Pungu.Store.CustomException;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("No such item is there...");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
