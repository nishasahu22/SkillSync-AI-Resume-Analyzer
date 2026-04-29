package com.skillsync.skillsync.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // =========================================
    // ❌ GENERIC ERROR
    // =========================================
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                Map.of(
                        "status", "error",
                        "message", e.getMessage()
                )
        );
    }

    // =========================================
    // ❌ RUNTIME ERROR
    // =========================================
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntime(RuntimeException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of(
                        "status", "error",
                        "message", e.getMessage()
                )
        );
    }

    // =========================================
    // ❌ VALIDATION ERROR
    // =========================================
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleValidation(IllegalArgumentException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                Map.of(
                        "status", "error",
                        "message", e.getMessage()
                )
        );
    }
}