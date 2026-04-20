package com.vaku.core_server.healthCenter.application.port.in;

import com.vaku.core_server.healthCenter.infraestructure.controller.dto.UpdateHealthCenterRequest;
import com.vaku.core_server.healthCenter.infraestructure.controller.dto.UpdateHealthCenterResponse;

import java.util.UUID;

public interface UpdateHealthCenterCase {
    UpdateHealthCenterResponse update(UUID id, UpdateHealthCenterRequest request);
}
