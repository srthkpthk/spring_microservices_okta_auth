package com.hotel.hotelservice.services;

import com.hotel.hotelservice.entities.Hotel;
import com.hotel.hotelservice.exceptions.ResourceNotFoundException;
import com.hotel.hotelservice.repo.HotelRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final HotelRepo hotelRepo;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String uuid = UUID.randomUUID().toString();
        hotel.setId(uuid);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + hotelId + " not found"));
    }
}
