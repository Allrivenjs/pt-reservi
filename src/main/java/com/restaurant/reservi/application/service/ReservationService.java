package com.restaurant.reservi.application.service;


import com.restaurant.reservi.application.dto.ReservationRequest;
import com.restaurant.reservi.application.dto.ReservationResponse;
import com.restaurant.reservi.domain.exception.EntityNotFoundException;
import com.restaurant.reservi.domain.exception.ReservationConflictException;
import com.restaurant.reservi.domain.model.Client;
import com.restaurant.reservi.domain.model.Reservation;
import com.restaurant.reservi.infrastruture.repository.AvailableSlotRepository;
import com.restaurant.reservi.infrastruture.repository.ClientRepository;
import com.restaurant.reservi.infrastruture.repository.ReservationRepository;
import com.restaurant.reservi.util.mapper.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final AvailableSlotRepository availableSlotRepository;
    private final ClientRepository clientRepository;
    private final RestaurantCapacityService restaurantCapacityService;

    public ReservationResponse createReservation(ReservationRequest request) {
        if (!restaurantCapacityService.canAccommodateReservation(request.getRestaurantId(), request.getCapacity())) {
            throw new IllegalStateException("No available seats for this reservation");
        }
        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new EntityNotFoundException("Client not found"));

        if (isNotSlotAvailable(request.getDate(), request.getTime())) {
            throw new ReservationConflictException("The selected slot is already reserved.");
        }

        Reservation reservation = ReservationMapper.INSTANCE.reservationRequestToReservation(request);
        reservation.setClient(client);
        Reservation savedReservation = reservationRepository.save(reservation);

        return mapToResponse(savedReservation);
    }

    public List<ReservationResponse> getReservationsByDate(LocalDate date) {
        return reservationRepository.findByDate(date).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public void updateReservation(Long id, ReservationRequest request) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reservation not found"));

        if (isNotSlotAvailable(request.getDate(), request.getTime())) {
            throw new ReservationConflictException("The selected slot is already reserved.");
        }

        reservation.setDate(request.getDate());
        reservation.setTime(request.getTime());
        reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new EntityNotFoundException("Reservation not found");
        }
        reservationRepository.deleteById(id);
    }

    private boolean isNotSlotAvailable(LocalDate date, LocalTime time) {
        return availableSlotRepository.findByDateAndIsAvailableTrue(date).stream()
                .noneMatch(slot -> slot.getTime().equals(time));
    }

    private ReservationResponse mapToResponse(Reservation reservation) {
        return ReservationMapper.INSTANCE.reservationToReservationResponse(reservation);
    }
}