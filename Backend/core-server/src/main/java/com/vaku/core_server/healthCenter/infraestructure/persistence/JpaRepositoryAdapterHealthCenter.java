package com.vaku.core_server.healthCenter.infraestructure.persistence;

import com.vaku.core_server.healthCenter.application.port.out.HealthCenterRepositoryPort;
import com.vaku.core_server.healthCenter.infraestructure.controller.dto.HealthCenterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaRepositoryAdapterHealthCenter implements HealthCenterRepositoryPort {

    private final SpringDateHealthCenterRepository springDateHealthCenterRepository;

    @Override
    public List<HealthCenterResponse> findAll() {
        return springDateHealthCenterRepository.findAll()
                .stream()
                .map(healthCenter -> new HealthCenterResponse(healthCenter.getId(), healthCenter.getName()))
                .toList();
    }
}
