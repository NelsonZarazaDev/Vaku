package com.vaku.core_server.country.infraestructure.inbound.controller;

import com.vaku.core_server.country.application.findAll.CountryFindAllCase;
import com.vaku.core_server.country.domain.model.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryFindAllCase countryFindAllCase;

    @GetMapping
    public List<Country> findAll() {
        return countryFindAllCase.findAllCountry();
    }
}
