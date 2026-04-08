package com.vaku.core_server.country.application.findAll;

import com.vaku.core_server.country.domain.model.Country;
import com.vaku.core_server.country.domain.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryFindAllCase {

    private final CountryRepository countryRepository;

    public List<Country> findAllCountry() {
        return countryRepository.findAll();
    }
}
