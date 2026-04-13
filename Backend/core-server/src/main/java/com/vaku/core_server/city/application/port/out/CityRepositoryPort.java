package com.vaku.core_server.city.application.port.out;

import com.vaku.core_server.city.infraestructure.controller.dto.CityResponse;

import java.util.List;

public interface CityRepositoryPort {
    List<CityResponse> findAllByDepartmentId(Long departmentId);
}
