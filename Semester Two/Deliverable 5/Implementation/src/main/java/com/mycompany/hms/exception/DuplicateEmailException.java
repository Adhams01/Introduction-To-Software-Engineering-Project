package com.mycompany.hms.exception;

/*
 * Contributed by: Adham
 * Task: A3 - Custom exception for duplicate email (409 Conflict)
 * Date: May 2026
 */
public class DuplicateEmailException extends RuntimeException {

    public DuplicateEmailException(String message) {
        super(message);
    }
}
