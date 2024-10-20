package com.user.service.utils;

import com.user.service.dto.UserDTO;
import com.user.service.entities.UserEntity;

public class UserDtoToEntityTransformer {

    public static UserEntity transformer(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();

        if(userDTO != null){
            userEntity.setUserId(userDTO.getUserId());
            userEntity.setName(userDTO.getName());
            userEntity.setEmail(userDTO.getEmail());
            userEntity.setAbout(userDTO.getAbout());
            userEntity.setRatings(userDTO.getRatings());
        }

        return userEntity;
    }


}
