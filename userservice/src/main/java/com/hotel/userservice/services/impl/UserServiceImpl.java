package com.hotel.userservice.services.impl;

import com.hotel.userservice.entities.Hotel;
import com.hotel.userservice.entities.Rating;
import com.hotel.userservice.entities.User;
import com.hotel.userservice.exceptions.InvalidParametersException;
import com.hotel.userservice.exceptions.ResourceNotFoundException;
import com.hotel.userservice.repos.UserRepo;
import com.hotel.userservice.services.HotelService;
import com.hotel.userservice.services.RatingService;
import com.hotel.userservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final HotelService hotelService;
    private final RatingService ratingService;

    @Override
    public User saveUser(User user) {
        String uuid = UUID.randomUUID().toString();
        user.setUid(uuid);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepo.findAll();
        return allUsers.stream().peek(user -> {
            List<Rating> ratings = ratingService.getRatings(user.getUid());
            List<Rating> collect = ratings.stream().peek(rating -> {
                Hotel hotel = hotelService.getHotel(rating.getHotelId());
                rating.setHotel(hotel);
            }).collect(Collectors.toList());
            user.setRatings(collect);
        }).collect(Collectors.toList());
    }

    @Override
    public User getUser(String userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + "not found in server"));
        List<Rating> ratings = ratingService.getRatings(userId);
        List<Rating> collect = ratings.stream().peek(rating -> {
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
        }).collect(Collectors.toList());
        user.setRatings(collect);
        return user;
    }

    @Override
    public User deleteUser(String userId) {
        User user = getUser(userId);
        userRepo.deleteById(userId);
        return user;
    }

    @Override
    public User updateUser(User user) {
        String userId = user.getUid();
        if (userId == null || userId.isEmpty()) {
            throw new InvalidParametersException("Please provide userId");
        }
        User existingUser = getUser(userId);

        if (user.getName() != null) {
            existingUser.setName(user.getName());
        }
        if (user.getEmail() != null) {
            existingUser.setEmail(user.getEmail());
        }
        if (user.getAbout() != null) {
            existingUser.setAbout(user.getAbout());
        }

        userRepo.save(existingUser);

        return existingUser;


    }
}
