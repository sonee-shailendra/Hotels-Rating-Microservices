package com.ssonee.hotel.services;

import com.ssonee.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {

    public Hotel getHotel(String hotelId);

    public List<Hotel> getAllHotels();

    public Hotel createHotel(Hotel hotel);
}
