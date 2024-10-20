package com.hotel.service.utils;

import com.hotel.service.dto.Hotel;
import com.hotel.service.entities.HotelEntity;

public class EntityToDtoTransformer {

    public static Hotel transformer(HotelEntity hotelEntity){
        Hotel hotel = new Hotel();
        if(hotelEntity != null){
            hotel.setId(hotelEntity.getId());
            hotel.setName(hotelEntity.getName());
            hotel.setLocation(hotelEntity.getLocation());
            hotel.setAbout(hotelEntity.getAbout());
        }
        return hotel;
    }
}
