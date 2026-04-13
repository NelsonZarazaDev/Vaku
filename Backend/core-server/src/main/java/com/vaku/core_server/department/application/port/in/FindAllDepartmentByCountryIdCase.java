package com.vaku.core_server.department.application.port.in;

import com.vaku.core_server.department.infraestructure.controller.dto.DepartmentResponse;

import java.util.List;

public interface FindAllDepartmentByCountryIdCase {
    List<DepartmentResponse> findAllDepartmentByCountryId(Long countryId);
}
