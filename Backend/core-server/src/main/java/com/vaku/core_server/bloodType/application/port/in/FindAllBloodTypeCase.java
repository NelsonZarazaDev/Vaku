package com.vaku.core_server.bloodType.application.port.in;

import com.vaku.core_server.bloodType.infraestructure.controller.dto.BloodTypeResponse;

import java.util.List;

public interface FindAllBloodTypeCase {
    List<BloodTypeResponse> findAllBloodType();
}
