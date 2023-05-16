package com.info.user.exception;

public class InvalidUserNameOrPasswordException extends Exception {

    public InvalidUserNameOrPasswordException() {
        super("Invalid user credentials");
    }
}
