package com.hotel.service.dao;

import com.hotel.service.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelDao extends JpaRepository<HotelEntity,String> {
}
