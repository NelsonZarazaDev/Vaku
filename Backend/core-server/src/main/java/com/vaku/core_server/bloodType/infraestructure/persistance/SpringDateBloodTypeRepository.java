package com.vaku.core_server.bloodType.infraestructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDateBloodTypeRepository extends JpaRepository<BloodTypeEntity, UUID> {
}
