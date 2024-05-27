package com.hotel.ratingservice.controller;

import com.hotel.ratingservice.entities.Rating;
import com.hotel.ratingservice.services.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@AllArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating user1 = ratingService.saveRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRating(@PathVariable String ratingId) {
        Rating user = ratingService.getRating(ratingId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings() {
        List<Rating> users = ratingService.getAllRatings();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingsByUser(@PathVariable String userId) {
        List<Rating> users = ratingService.getAllRatingsByUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingsByHotel(@PathVariable String hotelId) {
        List<Rating> users = ratingService.getAllRatingsByHotel(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }


}
