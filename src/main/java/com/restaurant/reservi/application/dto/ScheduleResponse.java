package com.restaurant.reservi.application.dto;

import lombok.Data;
import java.time.LocalTime;

@Data
public class ScheduleResponse {
    private Integer id;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer restaurantId;
}