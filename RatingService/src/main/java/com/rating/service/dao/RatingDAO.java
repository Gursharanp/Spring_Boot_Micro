package com.rating.service.dao;

import com.rating.service.entities.RatingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingDAO extends MongoRepository<RatingEntity,String> {

    //Get Rating by Hotel Id
    List<RatingEntity> findByHotelId(String hotelId);

    //Get Rating by UserId Id
    List<RatingEntity> findByUserId(String userId);

}
