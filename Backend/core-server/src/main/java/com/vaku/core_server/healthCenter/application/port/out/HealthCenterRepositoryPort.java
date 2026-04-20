package com.vaku.core_server.healthCenter.application.port.out;

import com.vaku.core_server.healthCenter.infraestructure.controller.dto.FindByIdHealthCenterResponse;
import com.vaku.core_server.healthCenter.infraestructure.controller.dto.HealthCenterResponse;
import com.vaku.core_server.healthCenter.infraestructure.persistence.HealthCenterEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HealthCenterRepositoryPort {
    List<HealthCenterResponse> findAllActive();

    Optional<HealthCenterEntity> findById(UUID id);

    HealthCenterEntity save(HealthCenterEntity dataHealthCenter);

    HealthCenterEntity update(HealthCenterEntity entity);

    boolean existsByName(String name);
}