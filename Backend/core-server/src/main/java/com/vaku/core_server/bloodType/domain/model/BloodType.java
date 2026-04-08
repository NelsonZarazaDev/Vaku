package com.vaku.core_server.bloodType.domain.model;

import com.vaku.core_server.bloodType.infraestructure.outbound.entity.BloodTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class BloodType {
    private UUID id;
    private String name;

    public BloodType(BloodTypeEntity bloodTypeEntity) {
        this.id = bloodTypeEntity.getId();
        this.name = bloodTypeEntity.getName();
    }
}
