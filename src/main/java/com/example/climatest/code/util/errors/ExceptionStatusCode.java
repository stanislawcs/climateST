package com.example.climatest.code.util.errors;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionStatusCode {
    ILLEGAL_CAR_CREDENTIALS(17),
    ILLEGAL_EMPLOYEE_CREDENTIALS(439);

    private final int statusCode;
}
