package com.sim.manager.validator;

import com.sim.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameUniqueValidator implements ConstraintValidator<UserNameUnique, String> {

    @Autowired
    private UserService userService;


    public void initialize(UserNameUnique constraint) {
    }

    public boolean isValid(String username, ConstraintValidatorContext context) {
        return userService.validtaeUser(username);
    }
}
