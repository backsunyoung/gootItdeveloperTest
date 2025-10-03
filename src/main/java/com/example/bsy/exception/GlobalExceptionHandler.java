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
                ex.getErrorType().name(),   // 예: EMAIL_EXISTS
                ex.getErrorType().getMessage() // 예: 이미 가입된 이메일입니다.
        );

        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }




}
