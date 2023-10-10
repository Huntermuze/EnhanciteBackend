package com.huntermuze.enhancite.exception;

public class InvalidDetailsException extends RuntimeException {
    public InvalidDetailsException(String message) {
        super(message);
    }

    public InvalidDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
}
