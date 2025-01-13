package com.restaurant.reservi.infrastruture.repository;



import com.restaurant.reservi.domain.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByDate(LocalDate date);
    Optional<Reservation> findByDateAndTime(LocalDate date, LocalTime time);
}
