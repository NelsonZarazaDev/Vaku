package com.vaku.core_server.country.domain.repository;

import com.vaku.core_server.country.domain.model.Country;

import java.util.List;

public interface CountryRepository {
    List<Country> findAll();
}
