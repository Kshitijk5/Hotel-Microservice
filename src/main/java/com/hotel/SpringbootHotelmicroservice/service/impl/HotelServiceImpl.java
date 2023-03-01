package com.hotel.SpringbootHotelmicroservice.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.SpringbootHotelmicroservice.customException.ResourceNotFoundException;
import com.hotel.SpringbootHotelmicroservice.entity.Hotel;
import com.hotel.SpringbootHotelmicroservice.repositories.HotelRepository;
import com.hotel.SpringbootHotelmicroservice.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String randomID = UUID.randomUUID().toString();
		hotel.setHotelId(randomID);
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotelById(String hotelId) {

		Hotel hotel = hotelRepository.findByHotelId(hotelId);

		if (hotel != null)
			return hotel;
		throw new ResourceNotFoundException("Hotel", "HotelID", hotelId);
	}

	@Override
	public List<Hotel> getAllHotels() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel updateHotel(String hotelId, Hotel hotel) {
		Hotel tempHotel = hotelRepository.findByHotelId(hotelId);

		if (tempHotel != null) {
			tempHotel.setName(hotel.getName());
			tempHotel.setLocation(hotel.getLocation());
			tempHotel.setAbout(hotel.getAbout());
			return hotelRepository.save(tempHotel);
		}
		throw new ResourceNotFoundException("Hotel", "HotelID", hotelId);
	}

	@Override
	public String deleteHotel(String hotelId) {
		Hotel hotel = hotelRepository.findByHotelId(hotelId);

		if (hotel != null) {
			hotelRepository.delete(hotel);
			return "Hotel with ID-"+hotelId+" deleted";

		}
		throw new ResourceNotFoundException("Hotel", "HotelID", hotelId);

	}

}
