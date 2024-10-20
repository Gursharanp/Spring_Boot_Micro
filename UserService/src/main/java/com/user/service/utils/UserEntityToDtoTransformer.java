package com.user.service.utils;

import com.user.service.dto.UserDTO;
import com.user.service.entities.UserEntity;

public class UserEntityToDtoTransformer {

    public static UserDTO transformer(UserEntity userEntity){
        UserDTO userDTO = new UserDTO();

        if(userEntity != null){
            userDTO.setUserId(userEntity.getUserId());
            userDTO.setName(userEntity.getName());
            userDTO.setEmail(userEntity.getEmail());
            userDTO.setAbout(userEntity.getAbout());
            userDTO.setRatings(userEntity.getRatings());
        }

        return userDTO;
    }
}
