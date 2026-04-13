package com.vaku.core_server.healthCenter.infraestructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class HealthCenterResponse {
    private UUID id;
    private String name;
}
