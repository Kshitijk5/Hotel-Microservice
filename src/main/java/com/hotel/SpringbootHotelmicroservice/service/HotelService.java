package com.hotel.SpringbootHotelmicroservice.service;

import java.util.List;

import com.hotel.SpringbootHotelmicroservice.entity.Hotel;

public interface HotelService {
  public Hotel createHotel(Hotel hotel);
  public Hotel getHotelById(String hotelId);
  public List<Hotel> getAllHotels();
  public Hotel updateHotel(String hotelId,Hotel hotel);
  public String deleteHotel(String hotelId);
}
