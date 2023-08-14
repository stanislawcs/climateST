package com.example.climatest.code.util.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionStatusCode {
    ILLEGAL_CAR_INFO(17),
    ILLEGAL_EMPLOYEE_INFO(439),
    ILLEGAL_CLIENT_INFO(443);

    private final int statusCode;
}
