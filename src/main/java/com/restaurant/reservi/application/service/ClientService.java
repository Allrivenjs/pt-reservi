package com.restaurant.reservi.application.service;

import com.restaurant.reservi.application.dto.ClientRequest;
import com.restaurant.reservi.application.dto.ClientResponse;
import com.restaurant.reservi.application.in.ClientUseCase;
import com.restaurant.reservi.domain.model.Client;
import com.restaurant.reservi.infrastruture.repository.ClientRepository;
import com.restaurant.reservi.util.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService implements ClientUseCase {
    private final ClientRepository clientRepository;

    public ClientResponse createClient(ClientRequest request) {
        Client client = ClientMapper.INSTANCE.clientRequestToClient(request);
        Client savedClient = clientRepository.save(client);
        return mapToResponse(savedClient);
    }

    public ClientResponse getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        return mapToResponse(client);
    }

    public ClientResponse updateClient(Long id, ClientRequest request) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        client.setName(request.getName());
        client.setEmail(request.getEmail());
        client.setPhoneNumber(request.getPhoneNumber());

        Client updatedClient = clientRepository.save(client);
        return mapToResponse(updatedClient);
    }

    @Override
    public ClientResponse getClientByEmail(String email) {
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        return mapToResponse(client);
    }

    private ClientResponse mapToResponse(Client client) {
        return ClientMapper.INSTANCE.clientToClientResponse(client);
    }
}
