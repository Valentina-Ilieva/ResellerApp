package com.resellerapp.model.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter

public class UserModel {
    private Long id;
    private String username;
    private String password;
    private String email;
}
