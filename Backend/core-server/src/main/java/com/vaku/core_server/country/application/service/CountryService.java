package com.vaku.core_server.country.application.service;

import com.vaku.core_server.country.application.port.in.FindAllCountryCase;
import com.vaku.core_server.country.application.port.out.CountryRepositoryPort;
import com.vaku.core_server.country.infraestructure.controller.dto.CountryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService implements FindAllCountryCase {

    private final CountryRepositoryPort countryRepositoryPort;

    @Override
    public List<CountryResponse> findAllCountry() {
        return countryRepositoryPort.findAll();
    }
}
