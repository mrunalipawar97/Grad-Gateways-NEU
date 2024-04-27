package com.gradgateways.neu.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.gradgateways.neu.model.Employer;

/**
*
* @author mrunalipawar
* class : EmployerValidator
*/

@Component
public class EmployerValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Employer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "employerEmail", "EmployerEmailEmpty", "Email can't be blank");
        ValidationUtils.rejectIfEmpty(errors, "employerPassword", "PasswordEmpty", "Password can't be blank");
        ValidationUtils.rejectIfEmpty(errors, "employerName", "EmployerNameEmpty",
                "Employer Name can't be blank");
        ValidationUtils.rejectIfEmpty(errors, "employerAddress", "EmployerAddressEmpty",
                "Employer Address can't be blank");
        ValidationUtils.rejectIfEmpty(errors, "employerEmail", "EmployerEmailEmpty",
                "Employer Email can't be blank");
        ValidationUtils.rejectIfEmpty(errors, "employerPassword", "EmployerPasswordEmpty",
                "Employer Password can't be blank");
    }
}
