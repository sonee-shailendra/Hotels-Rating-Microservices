package com.ssonee.hotel.services.impl;

import com.ssonee.hotel.entities.Hotel;
import com.ssonee.hotel.exceptions.ResourceNotFoundException;
import com.ssonee.hotel.repostitories.HotelRepository;
import com.ssonee.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(
                () -> new ResourceNotFoundException("Hotel with given HotelId is not found"));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = String.valueOf(UUID.randomUUID());
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }
}
