package com.restaurant.reservi.infrastruture.repository;

import com.restaurant.reservi.domain.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findByRestaurantId(Integer restaurantId);
}
