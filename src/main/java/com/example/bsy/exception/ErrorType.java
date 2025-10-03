package com.example.bsy.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorType {

    EMAIL_EXISTS("이미 가입된 이메일입니다.");

    private final String message;
}
