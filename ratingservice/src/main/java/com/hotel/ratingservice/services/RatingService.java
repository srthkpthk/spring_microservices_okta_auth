package com.hotel.ratingservice.services;


import com.hotel.ratingservice.entities.Rating;

import java.util.List;

public interface RatingService {
    Rating saveRating(Rating user);

    List<Rating> getAllRatings();

    List<Rating> getAllRatingsByUser(String userId);

    List<Rating> getAllRatingsByHotel(String hotelId);

    Rating getRating(String userId);

}