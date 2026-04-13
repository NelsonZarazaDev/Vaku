package com.vaku.core_server.country.application.port.in;

import com.vaku.core_server.country.infraestructure.controller.dto.CountryResponse;

import java.util.List;

public interface FindAllCountryCase {
    List<CountryResponse> findAllCountry();
}
