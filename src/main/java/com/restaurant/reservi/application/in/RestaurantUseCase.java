package com.restaurant.reservi.application.in;

import com.restaurant.reservi.application.dto.RestaurantRequest;
import com.restaurant.reservi.application.dto.RestaurantResponse;
import com.restaurant.reservi.domain.model.Restaurant;

import java.util.Optional;

public interface RestaurantUseCase {
    RestaurantResponse findById(Long id);
    RestaurantResponse save(RestaurantRequest restaurant);
    void deleteById(Long id);
}
