package com.vaku.core_server.bloodType.infraestructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class BloodTypeResponse {
    private UUID id;
    private String name;
}
