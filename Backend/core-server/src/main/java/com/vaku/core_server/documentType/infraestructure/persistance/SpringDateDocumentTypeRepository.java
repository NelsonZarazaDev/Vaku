package com.vaku.core_server.documentType.infraestructure.persistance;

import com.vaku.core_server.department.infraestructure.persistance.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringDateDocumentTypeRepository extends JpaRepository<DocumentTypeEntity, UUID> {
    List<DocumentTypeEntity> findByCountry_Id(Long countryId);
}
