package com.vaku.core_server.city.domain.model;

import com.vaku.core_server.city.infraestructure.outbound.entity.CityEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class City {
    private Long id;
    private String name;

    public City(CityEntity cityEntity) {
        this.id = cityEntity.getId();
        this.name = cityEntity.getName();
    }
}
