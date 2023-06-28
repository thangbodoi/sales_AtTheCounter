package com.example.demospring.utilities;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

public class NumberValidator implements ConstraintValidator<ValidNumber, String> {

    @Override
    public void initialize(ValidNumber constraintAnnotation) {
        // No initialization required
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Kiểm tra giá trị có phải là số hay không
        if (value == null) {
            return true;  // Cho phép giá trị null (tuỳ theo yêu cầu)
        }

        try {
            new BigDecimal(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
