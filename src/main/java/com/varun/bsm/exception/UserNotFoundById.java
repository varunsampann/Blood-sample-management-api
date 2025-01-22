package com.varun.bsm.exception;

public class UserNotFoundById extends  RuntimeException {
    private String message;

    public UserNotFoundById(String message) {
        super();
        this.message = message;
    }

    public String getMessaga() {
        return message;
    }
}
