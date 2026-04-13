package com.vaku.core_server.department.application.port.out;

import com.vaku.core_server.department.infraestructure.controller.dto.DepartmentResponse;

import java.util.List;

public interface DepartmentRepositoryPort {
    List<DepartmentResponse> findAllByCountryId(Long countryId);
}
