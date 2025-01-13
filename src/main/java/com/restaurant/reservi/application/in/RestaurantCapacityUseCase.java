package com.restaurant.reservi.application.in;

public interface RestaurantCapacityUseCase {
    boolean canAccommodateReservation(Long restaurantId, Integer requestedCapacity);
    void updateCapacity(Long restaurantId, Integer adjustment);
}
