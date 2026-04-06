package com.vaku.core_server.country.infraestructure.outbound.adapter;

import com.vaku.core_server.country.domain.model.Country;
import com.vaku.core_server.country.domain.repository.CountryRepository;
import com.vaku.core_server.country.infraestructure.outbound.database.CountryJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CountryRepositoryAdapter implements CountryRepository {

    private final CountryJpaRepository countryJpaRepository;

    @Override
    public List<Country> findAll() {
        return countryJpaRepository.findAll().stream()
                .map(Country::new)
                .toList();
    }
}
