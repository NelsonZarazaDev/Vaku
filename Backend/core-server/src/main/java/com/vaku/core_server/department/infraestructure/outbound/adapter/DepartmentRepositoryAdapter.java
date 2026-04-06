package com.vaku.core_server.department.infraestructure.outbound.adapter;

import com.vaku.core_server.department.domain.model.Department;
import com.vaku.core_server.department.domain.repository.DepartmentRepository;
import com.vaku.core_server.department.infraestructure.outbound.database.DepartmentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DepartmentRepositoryAdapter implements DepartmentRepository {

    private final DepartmentJpaRepository departmentJpaRepository;

    @Override
    public List<Department> findByCountryId(Long countryId) {
        return departmentJpaRepository.findByCountry_Id(countryId).stream()
                .map(Department::new)
                .toList();
    }
}
