package com.restaurant.reservi.application.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservationRequest {
    @NotNull
    private Long restaurantId;
    @NotNull
    private Long clientId;
    @NotNull
    private LocalDate date;
    @NotNull
    private LocalTime time;
    @NotNull
    @Min(1)
    private Integer capacity;
}
