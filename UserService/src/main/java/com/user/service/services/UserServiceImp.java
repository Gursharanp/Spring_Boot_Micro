package com.user.service.services;

import com.user.service.dao.UserDao;
import com.user.service.dto.Rating;
import com.user.service.dto.UserDTO;
import com.user.service.entities.UserEntity;
import com.user.service.exceptions.ResourceNotFound;
import com.user.service.utils.UserEntityToDtoTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.user.service.utils.UserEntityToDtoTransformer.transformer;
import static com.user.service.utils.UserDtoToEntityTransformer.transformer;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

    @Override
    public UserDTO saveUser(UserDTO userDTO) {

        if (userDTO != null){
            String randomUserId = UUID.randomUUID().toString();
            userDTO.setUserId(randomUserId);
            UserEntity savedUser = userDao.save(transformer(userDTO));
            return transformer(savedUser);
        }
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<UserEntity> userEntityList = userDao.findAll();
        userDTOList = userEntityList.stream().map(UserEntityToDtoTransformer::transformer).toList();
        return userDTOList;
    }

    @Override
    public UserDTO getUser(String id) {
        UserEntity userEntity= userDao.findById(id).orElseThrow(()-> new ResourceNotFound("User with given User ID #{id} is not found!"));

        //Get Ratings
        ArrayList<Rating> result = restTemplate.getForObject("http://localhost:8083/rating/getByUserId/dac6e67d-ea9a-4a91-ba22-ba834e33460f",ArrayList.class);
        if (result != null && !result.isEmpty()){
            userEntity.setRatings(result);
        }
        return transformer(userEntity);
    }


}
