package com.hotel.service.services;

import com.hotel.service.dto.Hotel;

import java.util.List;

public interface HotelService {
    //Add New Hotel
    Hotel save(Hotel hotel);

    //Get Hotel by Hotel Id
    Hotel getHotel(String id);

    //Get All Hotels

    List<Hotel> getAllHotels();
}
