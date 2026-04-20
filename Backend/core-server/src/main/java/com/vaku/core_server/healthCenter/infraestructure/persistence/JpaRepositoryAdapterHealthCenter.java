package com.vaku.core_server.healthCenter.infraestructure.persistence;

import com.vaku.core_server.healthCenter.application.port.out.HealthCenterRepositoryPort;
import com.vaku.core_server.healthCenter.infraestructure.controller.dto.FindByIdHealthCenterResponse;
import com.vaku.core_server.healthCenter.infraestructure.controller.dto.HealthCenterMapper;
import com.vaku.core_server.healthCenter.infraestructure.controller.dto.HealthCenterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaRepositoryAdapterHealthCenter implements HealthCenterRepositoryPort {
    private final SpringDateHealthCenterRepository springDateHealthCenterRepository;

    @Override
    public List<HealthCenterResponse> findAllActive() {
        return springDateHealthCenterRepository.findByStatusTrueAndDeleteAtIsNull()
                .stream()
                .map(HealthCenterMapper::toResponse)
                .toList();
    }

    @Override
    public Optional<HealthCenterEntity> findById(UUID id) {
        return springDateHealthCenterRepository.findById(id);
    }

    @Override
    public HealthCenterEntity save(HealthCenterEntity dataHealthCenter) {
        return springDateHealthCenterRepository.save(dataHealthCenter);
    }

    @Override
    public HealthCenterEntity update(HealthCenterEntity entity) {
        return springDateHealthCenterRepository.save(entity);
    }

    @Override
    public boolean existsByName(String name) {
        return springDateHealthCenterRepository.existsByName(name);
    }
}