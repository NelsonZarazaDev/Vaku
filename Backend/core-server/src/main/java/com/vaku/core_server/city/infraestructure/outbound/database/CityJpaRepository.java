package com.vaku.core_server.city.infraestructure.outbound.database;

import com.vaku.core_server.city.infraestructure.outbound.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityJpaRepository extends JpaRepository<CityEntity, Long> {
    List<CityEntity> findByDepartment_Id(Long departmentId);
}
