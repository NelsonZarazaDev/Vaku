package com.vaku.core_server.healthCenter.application.port.in;

import com.vaku.core_server.healthCenter.infraestructure.controller.dto.FindByIdHealthCenterResponse;

import java.util.UUID;

public interface FindByIdHealthCenterCase {
    FindByIdHealthCenterResponse findById(UUID id);
}
