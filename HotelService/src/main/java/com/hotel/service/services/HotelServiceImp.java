package com.hotel.service.services;

import com.hotel.service.dao.HotelDao;
import com.hotel.service.dto.Hotel;
import com.hotel.service.entities.HotelEntity;
import com.hotel.service.exceptions.ResourceNotFoundException;
import com.hotel.service.utils.EntityToDtoTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.hotel.service.utils.DtoToEntityTransformer.transformer;
import static com.hotel.service.utils.EntityToDtoTransformer.transformer;

@Service
public class HotelServiceImp implements HotelService{

    @Autowired
    private HotelDao hotelDao;

    @Override
    public Hotel save(Hotel hotel) {
        if (hotel != null){
            String randomId = UUID.randomUUID().toString();
            hotel.setId(randomId);
            HotelEntity savedHotel = hotelDao.save(transformer(hotel));
            return transformer(savedHotel);
        }
        return null;
    }

    @Override
    public Hotel getHotel(String id) {
        HotelEntity hotelEntity = hotelDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Record not found with Hotel Id "+id));
        return transformer(hotelEntity);
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotelList= new ArrayList<>();
        List<HotelEntity> hotelEntityList = hotelDao.findAll();
        if(!hotelEntityList.isEmpty()) {
            hotelList = hotelEntityList.stream().map(EntityToDtoTransformer::transformer).toList();
        }
        return hotelList;
    }


}
