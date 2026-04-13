package com.vaku.core_server.healthCenter.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDateHealthCenterRepository extends JpaRepository<HealthCenterEntity, UUID> {
}
