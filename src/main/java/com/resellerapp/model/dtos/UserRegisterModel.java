package com.resellerapp.model.dtos;

import com.resellerapp.vallidation.passwordMatcher.PasswordMatch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Setter
@Getter
@PasswordMatch
public class UserRegisterModel {
    @Size(min = 3, max = 20)
    @NotBlank
    private String username;

    @Size(min = 3, max = 20)
    @NotBlank
    private String password;

    @NotBlank
    private String confirmPassword;

    @Email
    @NotBlank
    private String email;
}
