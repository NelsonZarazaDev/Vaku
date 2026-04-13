package com.vaku.core_server.department.application.service;

import com.vaku.core_server.department.application.port.in.FindAllDepartmentByCountryIdCase;
import com.vaku.core_server.department.application.port.out.DepartmentRepositoryPort;
import com.vaku.core_server.department.infraestructure.controller.dto.DepartmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements FindAllDepartmentByCountryIdCase {

    private final DepartmentRepositoryPort departmentRepositoryPort;

    @Override
    public List<DepartmentResponse> findAllDepartmentByCountryId(Long countryId) {
        return departmentRepositoryPort.findAllByCountryId(countryId);
    }
}
