package com.hotel.SpringbootHotelmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.SpringbootHotelmicroservice.entity.Hotel;
import com.hotel.SpringbootHotelmicroservice.service.HotelService;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		return new ResponseEntity<>(hotelService.createHotel(hotel), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable("id") String hotelId) {
		return ResponseEntity.ok(hotelService.getHotelById(hotelId));
	}

	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels() {
		return new ResponseEntity<List<Hotel>>(hotelService.getAllHotels(), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel, @PathVariable("id") String hotelId) {
		return new ResponseEntity<Hotel>(hotelService.updateHotel(hotelId, hotel), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable("id") String hotelId) {
		return new ResponseEntity<String>(hotelService.deleteHotel(hotelId), HttpStatus.OK);
	}

}
