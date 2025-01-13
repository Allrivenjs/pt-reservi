package com.restaurant.reservi.application.dto;

import lombok.Data;
import java.time.LocalTime;

@Data
public class ScheduleRequest {
    private LocalTime startTime;
    private LocalTime endTime;
    private Long restaurantId;
}
