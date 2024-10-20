package com.rating.service.services;

import com.rating.service.dao.RatingDAO;
import com.rating.service.entities.RatingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImp implements  RatingService{


    @Autowired
    RatingDAO ratingDAO;

    @Override
    public RatingEntity saveRating(RatingEntity rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        return ratingDAO.save(rating);
    }

    @Override
    public List<RatingEntity> getAllRating() {
        return ratingDAO.findAll();
    }

    @Override
    public List<RatingEntity> getRatingByHotelId(String hotelId) {
        return ratingDAO.findByHotelId(hotelId);
    }

    @Override
    public List<RatingEntity> getRatingByUserId(String userId) {
        return ratingDAO.findByUserId(userId);
    }

    @Override
    public RatingEntity getRatingByRatingId(String ratingId) {
        return ratingDAO.findById(ratingId).orElseThrow(()->new RuntimeException("No Rating Found for Given Id"));
    }
}
