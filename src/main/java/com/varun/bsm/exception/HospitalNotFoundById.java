package com.varun.bsm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HospitalNotFoundById extends RuntimeException{

    private final String message;
}
