package com.example.server.exceptions;

public class UserNotFoundException extends RuntimeException{

    UserNotFoundException(Long id) {
        super("Could not find User " + id);
    }
}
