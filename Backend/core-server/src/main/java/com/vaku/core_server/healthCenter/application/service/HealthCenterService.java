package com.vaku.core_server.healthCenter.application.service;

import com.vaku.core_server.country.application.port.in.FindAllCountryCase;
import com.vaku.core_server.country.infraestructure.controller.dto.CountryResponse;
import com.vaku.core_server.healthCenter.application.port.in.FindAllHealthCenterCase;
import com.vaku.core_server.healthCenter.application.port.out.HealthCenterRepositoryPort;
import com.vaku.core_server.healthCenter.infraestructure.controller.dto.HealthCenterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HealthCenterService implements FindAllHealthCenterCase {

    private final HealthCenterRepositoryPort healthCenterRepositoryPort;

    @Override
    public List<HealthCenterResponse> findAllHealthCenter() {
        return healthCenterRepositoryPort.findAll();
    }
}
