package com.gradgateways.neu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.gradgateways.neu.model.Student;

/**
*
* @author mrunalipawar
* Class : StudentValidator
*/
@Component
public class StudentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Student.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "email", "EmailEmpty", "Email can't be empty");
        ValidationUtils.rejectIfEmpty(errors, "name", "NameEmpty", "Name can't be empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "PasswordEmpty", "Password can't be empty");  
    }
}
