package com.resellerapp.vallidation.validateUser;


import com.resellerapp.model.dtos.UserLoginModel;
import com.resellerapp.model.dtos.UserModel;
import com.resellerapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserLoginValidator implements ConstraintValidator<ValidateLoginForm, UserLoginModel> {

    private final UserService userService;

    @Autowired
    public UserLoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(ValidateLoginForm constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginModel userLoginModel, ConstraintValidatorContext context) {
        UserModel user = this.userService.findByUsername(userLoginModel.getUsername());
        return user.getId() != null
                && user.getPassword()
                .equals(userLoginModel.getPassword());
    }
}
