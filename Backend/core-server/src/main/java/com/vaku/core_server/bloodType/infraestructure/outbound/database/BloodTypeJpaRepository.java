package com.vaku.core_server.bloodType.infraestructure.outbound.database;

import com.vaku.core_server.bloodType.domain.model.BloodType;
import com.vaku.core_server.bloodType.infraestructure.outbound.entity.BloodTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BloodTypeJpaRepository extends JpaRepository<BloodTypeEntity, UUID> {
}
