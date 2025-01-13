package com.restaurant.reservi.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantRequest {
    private String name;
    private String address;
    private String phone;
    private LocalTime openingTime;
    private LocalTime closingTime;
}
