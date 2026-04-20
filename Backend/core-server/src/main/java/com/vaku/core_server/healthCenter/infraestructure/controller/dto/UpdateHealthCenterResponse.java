package com.vaku.core_server.healthCenter.infraestructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateHealthCenterResponse {
    private UUID id;
    private String name;
    private OffsetDateTime createdAt;
    private OffsetDateTime updateAt;
    private Long city_id;
}
