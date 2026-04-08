package com.vaku.core_server.department.infraestructure.outbound.database;

import com.vaku.core_server.department.infraestructure.outbound.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DepartmentJpaRepository extends JpaRepository<DepartmentEntity, Long> {
    List<DepartmentEntity> findByCountry_Id(Long country_id);
}
