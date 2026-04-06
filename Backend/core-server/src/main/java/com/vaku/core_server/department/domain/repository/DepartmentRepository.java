package com.vaku.core_server.department.domain.repository;

import com.vaku.core_server.department.domain.model.Department;

import java.util.List;

public interface DepartmentRepository {
    List<Department> findByCountryId(Long countryId);
}
