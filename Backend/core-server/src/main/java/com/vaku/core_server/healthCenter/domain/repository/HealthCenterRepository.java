package com.vaku.core_server.healthCenter.domain.repository;

import com.vaku.core_server.healthCenter.domain.model.HealthCenter;

import java.util.List;

public interface HealthCenterRepository {
    List<HealthCenter> findAll();
}
