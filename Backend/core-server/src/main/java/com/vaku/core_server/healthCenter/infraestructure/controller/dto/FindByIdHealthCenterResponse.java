package com.vaku.core_server.healthCenter.infraestructure.controller.dto;

import com.vaku.core_server.healthCenter.infraestructure.persistence.HealthCenterEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class FindByIdHealthCenterResponse {
    private UUID id;
    private String name;
    private Boolean status;
    private OffsetDateTime createdAt;
    private OffsetDateTime updateAt;
    private OffsetDateTime deleteAt;
    private Long cityId;
}
