package com.varun.bsm.exceptionhandler;

import com.varun.bsm.exception.BloodBankNotFoundById;
import com.varun.bsm.exception.UserNotFoundById;
import com.varun.bsm.utility.ErrorStructure;
import com.varun.bsm.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class BloodBankExceptionHandler {

private final RestResponseBuilder responseBuilder;
    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleBloodBankNotFoundById (BloodBankNotFoundById bx){

        return responseBuilder.error(HttpStatus.NOT_FOUND,bx.getMessage(), "BloodBank not found by the given id");


    }
}
