package com.restaurant.reservi.application.service;

import com.restaurant.reservi.application.dto.RestaurantRequest;
import com.restaurant.reservi.application.dto.RestaurantResponse;
import com.restaurant.reservi.application.in.RestaurantUseCase;
import com.restaurant.reservi.domain.model.Restaurant;
import com.restaurant.reservi.infrastruture.repository.RestaurantRepository;
import com.restaurant.reservi.util.mapper.RestaurantMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService implements RestaurantUseCase {
    private final RestaurantRepository restaurantRepository;

    @Override
    public RestaurantResponse findById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant not found"));
        return RestaurantMapper.INSTANCE.restaurantToRestaurantResponse(restaurant);
    }

    @Override
    public RestaurantResponse save(RestaurantRequest restaurant) {
        Restaurant restaurantToSave = RestaurantMapper.INSTANCE.restaurantRequestToRestaurant(restaurant);
        Restaurant savedRestaurant = restaurantRepository.save(restaurantToSave);
        return RestaurantMapper.INSTANCE.restaurantToRestaurantResponse(savedRestaurant);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        restaurant.ifPresent(restaurantRepository::delete);
    }
}
