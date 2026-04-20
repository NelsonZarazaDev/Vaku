package com.vaku.core_server.healthCenter.application.service;

import com.vaku.core_server.city.infraestructure.persistence.SpringDataCityRepository;
import com.vaku.core_server.healthCenter.application.port.in.CreateHealthCenterCase;
import com.vaku.core_server.healthCenter.application.port.in.FindAllHealthCenterCase;
import com.vaku.core_server.healthCenter.application.port.in.FindByIdHealthCenterCase;
import com.vaku.core_server.healthCenter.application.port.in.UpdateHealthCenterCase;
import com.vaku.core_server.healthCenter.application.port.out.HealthCenterRepositoryPort;
import com.vaku.core_server.healthCenter.infraestructure.controller.dto.*;
import com.vaku.core_server.healthCenter.infraestructure.persistence.HealthCenterEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.vaku.core_server.healthCenter.infraestructure.controller.dto.HealthCenterMapper.toCreateEntity;

@Service
@RequiredArgsConstructor
@Slf4j
public class HealthCenterService implements FindAllHealthCenterCase, FindByIdHealthCenterCase, CreateHealthCenterCase, UpdateHealthCenterCase {
    private final HealthCenterRepositoryPort healthCenterRepositoryPort;
    private final SpringDataCityRepository springDataCityRepository;

    @Override
    public List<HealthCenterResponse> findAllHealthCenter() {
        return healthCenterRepositoryPort.findAllActive();
    }

    @Override
    public FindByIdHealthCenterResponse findById(UUID id) {
        HealthCenterEntity entity = healthCenterRepositoryPort.findById(id).orElseThrow(() -> new RuntimeException("Centro de salud no encontrado"));
        return HealthCenterMapper.toFindByIdResponse(entity);
    }

    @Override
    public CreateHealthCenterResponse create(CreateHealthCenterRequest request) {

        if (healthCenterRepositoryPort.existsByName(request.getName())) {
            throw new RuntimeException("Ya existe");
        }

        var city = springDataCityRepository.findById((long) request.getCity_id())
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));

        var entity = toCreateEntity(request, city);
        var saved = healthCenterRepositoryPort.save(entity);
        return HealthCenterMapper.toCreateResponse(saved);
    }

    @Override
    public UpdateHealthCenterResponse update(UUID id, UpdateHealthCenterRequest request) {

        HealthCenterEntity entity = healthCenterRepositoryPort.findById(id)
                .orElseThrow(() -> new RuntimeException("HealthCenter no encontrado"));

        entity.setName(request.getName());
        entity.setStatus(request.getStatus());

        HealthCenterEntity updated = healthCenterRepositoryPort.save(entity);

        return HealthCenterMapper.toUpdateResponse(updated);
    }
}