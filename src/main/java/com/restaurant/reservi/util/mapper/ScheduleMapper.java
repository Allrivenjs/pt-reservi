package com.restaurant.reservi.util.mapper;

import com.restaurant.reservi.application.dto.ScheduleRequest;
import com.restaurant.reservi.application.dto.ScheduleResponse;
import com.restaurant.reservi.domain.model.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ScheduleMapper {
    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    Schedule scheduleRequestToSchedule(ScheduleRequest scheduleRequest);
    ScheduleResponse scheduleToScheduleResponse(Schedule schedule);

}
