package com.vaku.core_server.country.infraestructure.outbound.database;

import com.vaku.core_server.country.infraestructure.outbound.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryJpaRepository extends JpaRepository<CountryEntity, Long> {
}
