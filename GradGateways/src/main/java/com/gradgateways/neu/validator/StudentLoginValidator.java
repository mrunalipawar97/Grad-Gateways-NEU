package com.gradgateways.neu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gradgateways.neu.model.Student;


/**
*
* @author mrunalipawar
* class : StudentLoginValidator
*/

@Component
public class StudentLoginValidator implements Validator {
	
	@Override
    public boolean supports(Class<?> clazz) {
        return Student.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "email", "EmailEmpty", "Email can't be blank");
        ValidationUtils.rejectIfEmpty(errors, "password", "PasswordEmpty", "Password can't be blank");
    }
}


