package com.vaku.core_server.healthCenter.infraestructure.outbound.adapter;

import com.vaku.core_server.healthCenter.domain.model.HealthCenter;
import com.vaku.core_server.healthCenter.domain.repository.HealthCenterRepository;
import com.vaku.core_server.healthCenter.infraestructure.outbound.database.HealthCenterJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HealthCenterRepositoryAdapter implements HealthCenterRepository {
    private final HealthCenterJpaRepository healthCenterJpaRepository;

    @Override
    public List<HealthCenter> findAll() {
        return healthCenterJpaRepository.findAll().stream().map(HealthCenter::new).toList();
    }
}
