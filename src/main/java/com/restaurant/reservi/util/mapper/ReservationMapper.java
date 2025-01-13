package com.restaurant.reservi.util.mapper;

import com.restaurant.reservi.application.dto.ReservationRequest;
import com.restaurant.reservi.application.dto.ReservationResponse;
import com.restaurant.reservi.domain.model.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    Reservation reservationRequestToReservation(ReservationRequest reservationRequest);
    ReservationResponse reservationToReservationResponse(Reservation reservation);
}
