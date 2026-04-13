package com.vaku.core_server.country.infraestructure.persistance;

import com.vaku.core_server.country.application.port.out.CountryRepositoryPort;
import com.vaku.core_server.country.infraestructure.controller.dto.CountryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaRepositoryAdapterCountry implements CountryRepositoryPort {

    private final SpringDateCountryRepository springDateCountryRepository;

    @Override
    public List<CountryResponse> findAll() {
        return springDateCountryRepository.findAll()
                .stream()
                .map(country -> new CountryResponse(country.getId(), country.getName()))
                .toList();
    }
}
