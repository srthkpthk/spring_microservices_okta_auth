package com.hotel.hotelservice.services;

import com.hotel.hotelservice.entities.Hotel;

import java.util.List;


public interface HotelService {
    Hotel createHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotel(String hotelId);
}
