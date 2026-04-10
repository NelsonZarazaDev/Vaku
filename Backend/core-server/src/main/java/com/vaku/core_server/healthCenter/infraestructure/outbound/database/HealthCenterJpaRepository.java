package com.vaku.core_server.healthCenter.infraestructure.outbound.database;

import com.vaku.core_server.healthCenter.infraestructure.outbound.entity.HealthCenterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HealthCenterJpaRepository extends JpaRepository<HealthCenterEntity, UUID> {
}
