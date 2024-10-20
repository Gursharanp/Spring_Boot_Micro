package com.rating.service.controllers;

import com.rating.service.entities.RatingEntity;
import com.rating.service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping("/save")
    ResponseEntity<RatingEntity> saveRating(@RequestBody RatingEntity rating){
        RatingEntity savedRating = ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
    }

    @GetMapping("/getByRatingId/{ratingId}")
    ResponseEntity<RatingEntity> getRatingByRatingId(@PathVariable String ratingId){
        RatingEntity rating = ratingService.getRatingByRatingId(ratingId);
        return ResponseEntity.ok(rating);
    }

    @GetMapping("getByHotelId/{hotelId}")
    ResponseEntity<List<RatingEntity>> getRatingsByHotelId(@PathVariable String hotelId){
        List<RatingEntity> ratingsByHotel = ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.ok(ratingsByHotel);
    }

    @GetMapping("getByUserId/{userId}")
    ResponseEntity<List<RatingEntity>> getRatingsByUserId(@PathVariable String userId){
        List<RatingEntity> ratingsByUser = ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(ratingsByUser);
    }

    @GetMapping("getAllRatings")
    ResponseEntity<List<RatingEntity>> getAllRatings(){
        List<RatingEntity> ratings = ratingService.getAllRating();
        return ResponseEntity.ok(ratings);
    }


}
