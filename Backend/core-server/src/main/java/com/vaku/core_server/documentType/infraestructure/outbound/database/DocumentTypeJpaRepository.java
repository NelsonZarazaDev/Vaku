package com.vaku.core_server.documentType.infraestructure.outbound.database;

import com.vaku.core_server.documentType.infraestructure.outbound.entity.DocumentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentTypeJpaRepository extends JpaRepository<DocumentTypeEntity, Long> {
    List<DocumentTypeEntity> findByCountry_id(Long country_id);
}
