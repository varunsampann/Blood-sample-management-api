package com.varun.bsm.exceptionhandler;

import com.varun.bsm.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ObjectError> objectErrors = ex.getAllErrors();
        List<FieldErrorStructure> errors = new ArrayList<>();

        for (ObjectError objectError : objectErrors) {

            FieldError fieldError = (FieldError) objectError;
            errors.add(FieldErrorStructure.builder()
                    .field(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .rejectedValue(fieldError.getRejectedValue())
                    .build());
        }

        // Wrap the field errors into the error response structure
        ErrorStructure<List<FieldErrorStructure>> error = new ErrorStructure<>();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Invalid Input");
        error.setRootCause(errors);

        // Return a ResponseEntity with the custom error structure
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
   public static class FieldErrorStructure {
        private String field;
        private Object rejectedValue;
        private String message;
    }
}