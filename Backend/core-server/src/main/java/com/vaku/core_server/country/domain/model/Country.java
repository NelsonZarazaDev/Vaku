package com.vaku.core_server.country.domain.model;

import com.vaku.core_server.country.infraestructure.outbound.entity.CountryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Country {
    private Long id;
    private String name;

    public Country(CountryEntity countryEntity) {
        this.id = countryEntity.getId();
        this.name = countryEntity.getName();
    }
}
