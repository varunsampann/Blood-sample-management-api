package com.varun.bsm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserNotFoundById extends  RuntimeException {
    private final String message;

//    public UserNotFoundById(String message) {
//        super();
//        this.message = message;
//    }
//
//    public String getMessaga() {
//        return message;
//    }
}
