package com.vaku.core_server.country.infraestructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDateCountryRepository extends JpaRepository<CountryEntity,Long> {
}
