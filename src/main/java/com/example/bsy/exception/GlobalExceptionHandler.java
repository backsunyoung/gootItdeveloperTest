package com.example.bsy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.bsy.dto.ErrorResponseDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomException(CustomException ex) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                ex.getErrorType().name(),
                ex.getErrorType().getMessage()
        );

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }




}
