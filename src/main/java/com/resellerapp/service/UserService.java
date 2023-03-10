package com.resellerapp.service;

import com.resellerapp.model.dtos.UserModel;
import com.resellerapp.model.entity.User;
import com.resellerapp.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    public UserModel findByUsername (String username){
        return  this.modelMapper.map(this.userRepository.findByUsername(username)
                .orElse(new User()), UserModel.class);
    }
    public UserModel findById (Long id){
        return  this.modelMapper.map(this.userRepository.findById(id)
                .orElse(new User()), UserModel.class);
    }
}
