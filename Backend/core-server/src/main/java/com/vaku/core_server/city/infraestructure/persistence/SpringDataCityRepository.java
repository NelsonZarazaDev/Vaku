package com.vaku.core_server.city.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataCityRepository extends JpaRepository<CityEntity, Long> {
    List<CityEntity> findByDepartment_Id(Long departmentId);
}
