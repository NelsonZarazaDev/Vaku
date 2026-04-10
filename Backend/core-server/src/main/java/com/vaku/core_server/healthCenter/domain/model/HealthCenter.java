package com.vaku.core_server.healthCenter.domain.model;

import com.vaku.core_server.healthCenter.infraestructure.outbound.entity.HealthCenterEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class HealthCenter {
    private UUID id;
    private String name;

    public HealthCenter(HealthCenterEntity healthCenterEntity) {
        this.id = healthCenterEntity.getId();
        this.name = healthCenterEntity.getName();
    }
}
