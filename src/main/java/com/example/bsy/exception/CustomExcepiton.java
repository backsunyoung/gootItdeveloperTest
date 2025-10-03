package com.example.bsy.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomExcepiton extends RuntimeException{

    private final ErrorType errorType;
}
