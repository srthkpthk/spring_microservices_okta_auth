package com.hotel.ratingservice.services.impl;

import com.hotel.ratingservice.entities.Rating;
import com.hotel.ratingservice.exceptions.ResourceNotFoundException;
import com.hotel.ratingservice.repos.RatingRepo;
import com.hotel.ratingservice.services.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {
    private final RatingRepo ratingRepo;

    @Override
    public Rating saveRating(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getAllRatingsByUser(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingsByHotel(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }

    @Override
    public Rating getRating(String ratingId) {
        return ratingRepo.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("Rating with id " + ratingId + "not found in server"));
    }


}
