package com.skillsync.skillsync.exception;

public class CustomException extends RuntimeException {

    // 🔽 Constructor with message
    public CustomException(String message) {
        super(message);
    }

    // 🔽 Constructor with message + cause
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }
}