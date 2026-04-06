package com.vaku.core_server.city.application.findByDepartmentId;

import com.vaku.core_server.city.domain.model.City;
import com.vaku.core_server.city.domain.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityFindByDepartmentIdCase {
    private final CityRepository cityRepository;

    public List<City> FindByDepartmentId(Long departmentId) {
        return cityRepository.findByDepartmenId(departmentId);
    }
}
