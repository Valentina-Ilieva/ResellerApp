package com.resellerapp.service;


import com.resellerapp.model.dtos.UserLoginModel;
import com.resellerapp.model.dtos.UserRegisterModel;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.UserRepository;
import com.resellerapp.util.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    @Autowired
    public AuthService(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    public void registerUser(UserRegisterModel userRegisterModel){
        User user = this.userRepository.saveAndFlush(this.modelMapper.map(userRegisterModel, User.class));

    }
    public void loginUser (UserLoginModel userLoginModel){
        User byUsername = this.userRepository.findByUsername(userLoginModel.getUsername())
                .get();
        this.loggedUser.setId(byUsername.getId());

    }

    public void logoutUser(){
        loggedUser.clearUser();
    }
}


