package com.hotel.service.controllers;

import com.hotel.service.dto.Hotel;
import com.hotel.service.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/save")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.save(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
    }

    @GetMapping("/getAllHotels")
    public ResponseEntity<List<Hotel>> getAllHotels(){
        List<Hotel> hotelList = hotelService.getAllHotels();
        return ResponseEntity.ok().body(hotelList);
    }

    @GetMapping("/getHotel/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable String id){
        Hotel hotel = hotelService.getHotel(id);
        return ResponseEntity.ok().body(hotel);

    }


}
