package com.restaurant.reservi.util.mapper;

import com.restaurant.reservi.application.dto.ClientRequest;
import com.restaurant.reservi.application.dto.ClientResponse;
import com.restaurant.reservi.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    Client clientRequestToClient(ClientRequest clientRequest);
    ClientResponse clientToClientResponse(Client client);
}
