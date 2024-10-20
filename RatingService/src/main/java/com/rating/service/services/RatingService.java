package com.rating.service.services;

import com.rating.service.entities.RatingEntity;

import java.util.List;

public interface RatingService {
    //Save Rating
    RatingEntity saveRating(RatingEntity rating);

    //Get All Rating
    List<RatingEntity> getAllRating();

    //Get Rating By Hotel Id
    List<RatingEntity> getRatingByHotelId(String hotelId);

    //Get Rating By User Id
    List<RatingEntity> getRatingByUserId(String userId);

    //Get Rating By Id
    RatingEntity getRatingByRatingId(String ratingId);
}
