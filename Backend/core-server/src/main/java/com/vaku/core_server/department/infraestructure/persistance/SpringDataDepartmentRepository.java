package com.vaku.core_server.department.infraestructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataDepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    List<DepartmentEntity> findByCountry_Id(Long countryId);
}
