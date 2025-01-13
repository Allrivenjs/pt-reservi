package com.restaurant.reservi.application.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AvailableSlotResponse {
    private LocalDate date;
    private LocalTime time;
}
