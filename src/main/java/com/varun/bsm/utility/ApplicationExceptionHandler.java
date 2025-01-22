package com.varun.bsm.utility;

import com.varun.bsm.exception.UserNotFoundById;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler
    public ErrorStructure  handleUserNotFoundById(UserNotFoundById ux){

        return ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ux.getMessage(), "user not found by given id");

    }


}
