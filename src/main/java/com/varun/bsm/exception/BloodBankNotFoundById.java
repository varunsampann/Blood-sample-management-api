package com.varun.bsm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@AllArgsConstructor
@Getter
public class BloodBankNotFoundById extends RuntimeException{
    private final String message;
}
