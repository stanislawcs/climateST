package com.example.climatest.code.util.errors;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

public class ErrorsUtil {

    public static String getErrorsToClient(BindingResult bindingResult) {
        StringBuilder result = new StringBuilder();
        List<FieldError> errors = bindingResult.getFieldErrors();

        for (FieldError e : errors) {
            result.append(e.getField()).append("-")
                    .append(e.getDefaultMessage()).append(";");
        }

        return result.toString();
    }
}
