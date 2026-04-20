package com.vaku.core_server.healthCenter.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDateHealthCenterRepository extends JpaRepository<HealthCenterEntity, UUID> {

    List<HealthCenterEntity> findByStatusTrueAndDeleteAtIsNull();

    boolean existsByName(String name);
}