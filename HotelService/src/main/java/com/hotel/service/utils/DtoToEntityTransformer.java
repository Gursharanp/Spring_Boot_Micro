package com.hotel.service.utils;

import com.hotel.service.dto.Hotel;
import com.hotel.service.entities.HotelEntity;

public class DtoToEntityTransformer {
    public static HotelEntity transformer(Hotel hotel){
        HotelEntity hotelEntity = new HotelEntity();
        if(hotel != null){
            hotelEntity.setId(hotel.getId());
            hotelEntity.setName(hotel.getName());
            hotelEntity.setLocation(hotel.getLocation());
            hotelEntity.setAbout(hotel.getAbout());
        }
        return hotelEntity;
    }
}
