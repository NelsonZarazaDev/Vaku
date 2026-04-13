package com.vaku.core_server.country.application.port.out;

import com.vaku.core_server.country.infraestructure.controller.dto.CountryResponse;

import java.util.List;

public interface CountryRepositoryPort {
    List<CountryResponse> findAll();
}
