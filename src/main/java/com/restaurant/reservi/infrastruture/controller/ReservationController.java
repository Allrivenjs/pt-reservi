package com.restaurant.reservi.infrastruture.controller;


import com.restaurant.reservi.application.dto.ReservationRequest;
import com.restaurant.reservi.application.dto.ReservationResponse;
import com.restaurant.reservi.application.service.ReservationService;
import com.restaurant.reservi.domain.exception.ReservationConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponse> createReservation(@RequestBody ReservationRequest reservationRequest) {
        try {
            ReservationResponse response = reservationService.createReservation(reservationRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (ReservationConflictException e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<ReservationResponse>> getReservationsByDate(@PathVariable LocalDate date) {
        List<ReservationResponse> reservations = reservationService.getReservationsByDate(date);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateReservation(
            @PathVariable Long id, @RequestBody ReservationRequest reservationRequest) {
        reservationService.updateReservation(id, reservationRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}