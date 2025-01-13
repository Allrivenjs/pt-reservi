package com.restaurant.reservi.application.in;

import com.restaurant.reservi.application.dto.ClientRequest;
import com.restaurant.reservi.application.dto.ClientResponse;

public interface ClientUseCase {
    ClientResponse createClient(ClientRequest clientRequest);
    ClientResponse getClientById(Long id);
    ClientResponse updateClient(Long id, ClientRequest clientRequest);
    ClientResponse getClientByEmail(String email);
}
