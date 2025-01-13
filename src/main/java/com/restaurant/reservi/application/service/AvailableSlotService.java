package com.restaurant.reservi.application.service;

import com.restaurant.reservi.application.dto.AvailableSlotResponse;
import com.restaurant.reservi.infrastruture.repository.AvailableSlotRepository;
import com.restaurant.reservi.util.mapper.AvailableSlotMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AvailableSlotService {
    private final AvailableSlotRepository availableSlotRepository;

    public List<AvailableSlotResponse> getAvailableSlotsByDate(LocalDate date) {
        return availableSlotRepository.findByDateAndIsAvailableTrue(date).stream()
                .map(AvailableSlotMapper.INSTANCE::availableSlotToAvailableSlotResponse)
                .toList();
    }
}
