package com.restaurant.reservi.infrastruture.repository;

import com.restaurant.reservi.domain.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
