package com.example.climatest.code.util.errors;

public enum ExceptionStatusCode {
    ILLEGAL_CAR_CREDENTIALS(17),
    ILLEGAL_EMPLOYEE_CREDENTIALS(439);

    private int statusCode;

    public int getStatusCode(){
        return statusCode;
    }

    ExceptionStatusCode(int statusCode){
        this.statusCode = statusCode;
    }

}
