package com.restaurant.reservi.infrastruture.repository;

import com.restaurant.reservi.domain.model.AvailableSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AvailableSlotRepository extends JpaRepository<AvailableSlot, Long> {
    List<AvailableSlot> findByDateAndIsAvailableTrue(LocalDate date);
}