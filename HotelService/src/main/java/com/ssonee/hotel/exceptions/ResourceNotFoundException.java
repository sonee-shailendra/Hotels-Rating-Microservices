package com.ssonee.hotel.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("Resource Not Found on server !!");
    }

    public  ResourceNotFoundException(String msg) {
        super(msg);
    }
}
