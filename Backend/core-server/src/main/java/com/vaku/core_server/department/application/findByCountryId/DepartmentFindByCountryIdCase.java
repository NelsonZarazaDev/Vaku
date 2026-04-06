package com.vaku.core_server.department.application.findByCountryId;

import com.vaku.core_server.department.domain.model.Department;
import com.vaku.core_server.department.domain.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentFindByCountryIdCase {
    private final DepartmentRepository departmentRepository;

    public List<Department> findByCountry(Long countryId) {
        return departmentRepository.findByCountryId(countryId);
    }
}
