package com.varun.bsm.exceptionhandler;

import com.varun.bsm.exception.SampleNotFoundById;
import com.varun.bsm.utility.ErrorStructure;
import com.varun.bsm.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class SampleExceptionHandler {

    private RestResponseBuilder responseBuilder;
    @ExceptionHandler
    public ResponseEntity<ErrorStructure<String>> handleSampleNotfoundById(SampleNotFoundById sx){

        return responseBuilder.error(HttpStatus.NOT_FOUND,sx.getMessage(), "Sample not found by the given id");

    }
}
