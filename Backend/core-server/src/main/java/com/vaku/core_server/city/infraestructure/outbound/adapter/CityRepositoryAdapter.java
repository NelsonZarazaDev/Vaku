package com.vaku.core_server.city.infraestructure.outbound.adapter;

import com.vaku.core_server.city.domain.model.City;
import com.vaku.core_server.city.domain.repository.CityRepository;
import com.vaku.core_server.city.infraestructure.outbound.database.CityJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CityRepositoryAdapter implements CityRepository {

    private final CityJpaRepository cityJpaRepository;

    @Override
    public List<City> findByDepartmenId(Long department_id) {
        return cityJpaRepository.findByDepartment_Id(department_id).stream()
                .map(City::new)
                .toList();
    }
}
