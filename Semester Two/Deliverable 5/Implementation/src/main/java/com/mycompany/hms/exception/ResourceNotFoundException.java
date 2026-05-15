package com.mycompany.hms.exception;

/*
 * Contributed by: Yassin
 * Task: Y3 - Custom exception for 404 errors
 * Date: May 2026
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
