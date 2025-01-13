package com.restaurant.reservi.infrastruture.controller;

import com.restaurant.reservi.application.dto.AvailableSlotResponse;
import com.restaurant.reservi.application.service.AvailableSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/available-slots")
@RequiredArgsConstructor
public class AvailableSlotController {
    private final AvailableSlotService availableSlotService;

    @GetMapping("/date/{date}")
    public ResponseEntity<List<AvailableSlotResponse>> getAvailableSlots(@PathVariable LocalDate date) {
        List<AvailableSlotResponse> availableSlots = availableSlotService.getAvailableSlotsByDate(date);
        return new ResponseEntity<>(availableSlots, HttpStatus.OK);
    }
}
