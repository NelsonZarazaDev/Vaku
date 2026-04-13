package com.vaku.core_server.healthCenter.application.port.in;

import com.vaku.core_server.healthCenter.infraestructure.controller.dto.HealthCenterResponse;

import java.util.List;

public interface FindAllHealthCenterCase {
    List<HealthCenterResponse> findAllHealthCenter();
}
