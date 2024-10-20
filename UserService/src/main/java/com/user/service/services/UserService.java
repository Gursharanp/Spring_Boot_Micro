package com.user.service.services;

import com.user.service.dto.UserDTO;

import java.util.List;

public interface UserService {
    //To save user
    UserDTO saveUser(UserDTO userDTO);

    //To Get All Users
    List<UserDTO> getAllUsers();

    //To Get User By User Id
    UserDTO getUser(String id);
}
