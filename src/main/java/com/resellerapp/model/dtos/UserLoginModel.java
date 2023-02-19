package com.resellerapp.model.dtos;

import com.resellerapp.vallidation.validateUser.ValidateLoginForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@ValidateLoginForm
public class UserLoginModel {
    private String username;
    private String password;
}