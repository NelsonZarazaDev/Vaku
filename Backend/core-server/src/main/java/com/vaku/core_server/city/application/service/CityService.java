package com.vaku.core_server.city.application.service;

import com.vaku.core_server.city.application.port.in.FindAllCityByDepartmentIdCase;
import com.vaku.core_server.city.application.port.out.CityRepositoryPort;
import com.vaku.core_server.city.infraestructure.controller.dto.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService implements FindAllCityByDepartmentIdCase {

    private final CityRepositoryPort cityRepositoryPort;

    @Override
    public List<CityResponse> findAllCityByDepartmentId(Long departmentId) {
        return cityRepositoryPort.findAllByDepartmentId(departmentId);
    }
}
