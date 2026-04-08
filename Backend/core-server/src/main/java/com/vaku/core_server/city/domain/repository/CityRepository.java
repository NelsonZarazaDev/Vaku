package com.vaku.core_server.city.domain.repository;

import com.vaku.core_server.city.domain.model.City;

import java.util.List;

public interface CityRepository {
    List<City> findByDepartmenId(Long department_id);
}
