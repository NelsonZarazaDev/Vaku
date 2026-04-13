package com.vaku.core_server.city.application.port.in;

import com.vaku.core_server.city.infraestructure.controller.dto.CityResponse;

import java.util.List;

public interface FindAllCityByDepartmentIdCase {
    List<CityResponse> findAllCityByDepartmentId(Long departmentId);
}
