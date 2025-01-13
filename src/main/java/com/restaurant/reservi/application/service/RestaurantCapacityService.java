package com.restaurant.reservi.application.service;

import com.restaurant.reservi.application.in.RestaurantCapacityUseCase;
import com.restaurant.reservi.domain.model.Restaurant;
import com.restaurant.reservi.infrastruture.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantCapacityService implements RestaurantCapacityUseCase {
    private final RestaurantRepository restaurantRepository;

    public boolean canAccommodateReservation(Long restaurantId, Integer requestedCapacity) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        int availableCapacity = restaurant.getTotalCapacity() - restaurant.getOccupiedCapacity();
        return availableCapacity >= requestedCapacity;
    }

    public void updateCapacity(Long restaurantId, Integer adjustment) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        int newOccupiedCapacity = restaurant.getOccupiedCapacity() + adjustment;

        if (newOccupiedCapacity < 0 || newOccupiedCapacity > restaurant.getTotalCapacity()) {
            throw new IllegalStateException("Invalid capacity adjustment");
        }

        restaurant.setOccupiedCapacity(newOccupiedCapacity);
        restaurantRepository.save(restaurant);
    }
}
