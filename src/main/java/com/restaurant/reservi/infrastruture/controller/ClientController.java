package com.restaurant.reservi.infrastruture.controller;

import com.restaurant.reservi.application.dto.ClientRequest;
import com.restaurant.reservi.application.dto.ClientResponse;
import com.restaurant.reservi.application.in.ClientUseCase;
import com.restaurant.reservi.application.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientUseCase clientService;

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@RequestBody ClientRequest clientRequest) {
        ClientResponse clientResponse = clientService.createClient(clientRequest);
        return new ResponseEntity<>(clientResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> getClientById(@PathVariable Long id) {
        ClientResponse clientResponse = clientService.getClientById(id);
        return new ResponseEntity<>(clientResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> updateClient(
            @PathVariable Long id, @RequestBody ClientRequest clientRequest) {
        ClientResponse updatedClient = clientService.updateClient(id, clientRequest);
        return new ResponseEntity<>(updatedClient, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ClientResponse> getClientByEmail(@PathVariable String email) {
        ClientResponse clientResponse = clientService.getClientByEmail(email);
        return new ResponseEntity<>(clientResponse, HttpStatus.OK);
    }
}
