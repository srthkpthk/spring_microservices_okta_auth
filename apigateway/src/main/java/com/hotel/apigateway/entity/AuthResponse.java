package com.hotel.apigateway.entity;

import lombok.*;

import java.util.Collection;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String token;
    private String userId;
    private String refreshToken;
    private Long expireIn;
    private Collection<String> authorities;
}
