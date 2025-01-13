package com.restaurant.reservi.application.dto;


import lombok.Data;

@Data
public class ClientRequest {
    private String name;
    private String email;
    private String phoneNumber;
}
