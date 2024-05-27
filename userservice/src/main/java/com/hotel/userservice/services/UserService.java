package com.hotel.userservice.services;

import com.hotel.userservice.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUsers();

    User getUser(String userId);

    User deleteUser(String userId);

    User updateUser(User user);

}