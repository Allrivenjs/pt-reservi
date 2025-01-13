package com.restaurant.reservi.application.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservationResponse {
    private Long id;
    private String clientName;
    private LocalDate date;
    private LocalTime time;
}
