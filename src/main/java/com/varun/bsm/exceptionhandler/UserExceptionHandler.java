package com.varun.bsm.exceptionhandler;

import com.varun.bsm.exception.UserNotFoundById;
import com.varun.bsm.utility.ErrorStructure;
import com.varun.bsm.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor

public class UserExceptionHandler {
   private final RestResponseBuilder responseBuilder;

@ExceptionHandler
   public ResponseEntity<ErrorStructure<String>> handleUserNotFoundById (UserNotFoundById ux){

      return responseBuilder.error(HttpStatus.NOT_FOUND,ux.getMessage(), "user not found by the given id");
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorStructure<String>> handleUserNotFoundById (UsernameNotFoundException ux){

        return responseBuilder.error(HttpStatus.NOT_FOUND,ux.getMessage(), "user not found by the given id");
    }


}
