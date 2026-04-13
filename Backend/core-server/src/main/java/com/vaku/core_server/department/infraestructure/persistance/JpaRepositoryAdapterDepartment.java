package com.vaku.core_server.department.infraestructure.persistance;

import com.vaku.core_server.department.application.port.out.DepartmentRepositoryPort;
import com.vaku.core_server.department.infraestructure.controller.dto.DepartmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaRepositoryAdapterDepartment implements DepartmentRepositoryPort {

    private final SpringDataDepartmentRepository springDataDepartmentRepository;

    @Override
    public List<DepartmentResponse> findAllByCountryId(Long countryId) {
        return springDataDepartmentRepository.findByCountry_Id(countryId)
                .stream()
                .map(department -> new DepartmentResponse(department.getId(), department.getName()))
                .toList();
    }
}
