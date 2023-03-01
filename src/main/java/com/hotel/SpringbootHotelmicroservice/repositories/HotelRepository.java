package com.hotel.SpringbootHotelmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.SpringbootHotelmicroservice.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,String> {
   Hotel findByHotelId(String hotelId);
}
