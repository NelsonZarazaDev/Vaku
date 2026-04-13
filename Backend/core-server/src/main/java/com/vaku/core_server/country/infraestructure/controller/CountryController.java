package com.vaku.core_server.country.infraestructure.controller;

import com.vaku.core_server.country.application.port.in.FindAllCountryCase;
import com.vaku.core_server.country.infraestructure.controller.dto.CountryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {
    private final FindAllCountryCase findAllCountryCase;

    @GetMapping
    public List<CountryResponse> findAllCountry() {
        return findAllCountryCase.findAllCountry();
    }
}
