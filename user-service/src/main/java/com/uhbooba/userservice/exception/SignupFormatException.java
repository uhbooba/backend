package com.uhbooba.userservice.exception;

public class SignupFormatException extends RuntimeException {

    public SignupFormatException() {
        super("회원가입 형식이 올바르지 않습니다.");
    }
}
