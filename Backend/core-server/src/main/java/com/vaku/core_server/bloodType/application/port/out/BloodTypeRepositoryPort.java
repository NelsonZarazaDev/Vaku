package com.vaku.core_server.bloodType.application.port.out;

import com.vaku.core_server.bloodType.infraestructure.controller.dto.BloodTypeResponse;

import java.util.List;

public interface BloodTypeRepositoryPort {
    List<BloodTypeResponse> findAll();
}
