package com.hotel.userservice.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hotel {
    private String id;
    private String name;
    private String location;
    private String about;
}
