package com.restaurant.reservi.application.service;

import com.restaurant.reservi.application.dto.ScheduleRequest;
import com.restaurant.reservi.application.dto.ScheduleResponse;
import com.restaurant.reservi.application.in.ScheduleUseCase;
import com.restaurant.reservi.domain.model.Schedule;
import com.restaurant.reservi.infrastruture.repository.RestaurantRepository;
import com.restaurant.reservi.infrastruture.repository.ScheduleRepository;
import com.restaurant.reservi.util.mapper.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ScheduleService implements ScheduleUseCase {
    private final ScheduleRepository scheduleRepository;
    private final RestaurantRepository restaurantRepository;


    @Override
    public ScheduleResponse save(ScheduleRequest schedule) {
        Schedule scheduleToSave = ScheduleMapper.INSTANCE.scheduleRequestToSchedule(schedule);
        scheduleToSave.setRestaurant(restaurantRepository.findById(schedule.getRestaurantId()).orElseThrow(()->
                new RuntimeException("Restaurant not found")));
        return ScheduleMapper.INSTANCE.scheduleToScheduleResponse(scheduleRepository.save(scheduleToSave));
    }

    @Override
    public List<ScheduleResponse> findByRestaurantId(Integer restaurantId) {
       return scheduleRepository.findByRestaurantId(restaurantId).stream()
               .map(ScheduleMapper.INSTANCE::scheduleToScheduleResponse)
               .toList();
    }

    @Override
    public void deleteById(Integer id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        scheduleRepository.delete(schedule);
    }
}
