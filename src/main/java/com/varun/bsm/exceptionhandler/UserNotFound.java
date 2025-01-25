package com.varun.bsm.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserNotFound {
    private final  String message;
}
