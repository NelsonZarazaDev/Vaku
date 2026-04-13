package com.vaku.core_server.city.infraestructure.persistence;

import com.vaku.core_server.city.application.port.out.CityRepositoryPort;
import com.vaku.core_server.city.infraestructure.controller.dto.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaRepositoryAdapterCity implements CityRepositoryPort {

    private final SpringDataCityRepository springDataCityRepository;

    @Override
    public List<CityResponse> findAllByDepartmentId(Long departmentId) {
        return springDataCityRepository.findByDepartment_Id(departmentId)
                .stream()
                .map(city -> new CityResponse(city.getId(), city.getName()))
                .toList();
    }
}
