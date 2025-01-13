package com.restaurant.reservi.util.mapper;

import com.restaurant.reservi.application.dto.AvailableSlotResponse;
import com.restaurant.reservi.domain.model.AvailableSlot;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AvailableSlotMapper {
    AvailableSlotMapper INSTANCE = Mappers.getMapper(AvailableSlotMapper.class);

    AvailableSlotResponse availableSlotToAvailableSlotResponse(AvailableSlot availableSlot);
}
