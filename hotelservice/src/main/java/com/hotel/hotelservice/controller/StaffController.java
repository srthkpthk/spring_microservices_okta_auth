package com.hotel.hotelservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @GetMapping
    public ResponseEntity<List<String>> getStaffs() {
        List<String> strings = Arrays.asList("staff", "staff", "staff", "staff", "staff");
        return ResponseEntity.ok(strings);
    }
}
