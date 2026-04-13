package com.vaku.core_server.healthCenter.application.port.out;

import com.vaku.core_server.healthCenter.infraestructure.controller.dto.HealthCenterResponse;

import java.util.List;

public interface HealthCenterRepositoryPort {
    List<HealthCenterResponse> findAll();
}
