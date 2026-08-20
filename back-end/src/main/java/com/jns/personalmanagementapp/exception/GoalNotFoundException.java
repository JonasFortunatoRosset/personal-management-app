package com.jns.personalmanagementapp.exception;

public class GoalNotFoundException extends RuntimeException {
    public GoalNotFoundException(String message) {
        super(message);
    }
}
