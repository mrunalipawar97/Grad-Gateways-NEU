package com.gradgateways.neu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.gradgateways.neu.model.Employer;

/**
*
* @author mrunalipawar
* class : EmployerLoginValidator
*/

@Component
public class EmployerLoginValidator implements Validator {

	@Override
    public boolean supports(Class<?> clazz) {
        return Employer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "employerEmail", "EmployerEmailEmpty",
                "Employer Email can't be blank");
        ValidationUtils.rejectIfEmpty(errors, "employerPassword", "EmployerPasswordEmpty",
                "Employer Password can't be blank");
    }

}
