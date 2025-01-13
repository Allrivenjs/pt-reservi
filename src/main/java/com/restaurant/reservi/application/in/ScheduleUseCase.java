package com.restaurant.reservi.application.in;

import com.restaurant.reservi.application.dto.ScheduleRequest;
import com.restaurant.reservi.application.dto.ScheduleResponse;
import com.restaurant.reservi.domain.model.Schedule;

import java.util.List;

public interface ScheduleUseCase {
    ScheduleResponse save(ScheduleRequest schedule);
    List<ScheduleResponse> findByRestaurantId(Integer restaurantId);
    void deleteById(Integer id);
}
