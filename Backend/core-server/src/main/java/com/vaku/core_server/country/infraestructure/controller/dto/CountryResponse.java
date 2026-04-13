package com.vaku.core_server.country.infraestructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CountryResponse {
    private final Long id;
    private final String name;
}
