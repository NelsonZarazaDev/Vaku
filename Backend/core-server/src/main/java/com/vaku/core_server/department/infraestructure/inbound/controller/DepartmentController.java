package com.vaku.core_server.department.infraestructure.inbound.controller;

import com.vaku.core_server.department.application.findByCountryId.DepartmentFindByCountryIdCase;
import com.vaku.core_server.department.domain.model.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentFindByCountryIdCase departmentFindByCountryIdCase;

    @GetMapping(path = "{countryId}")
    public List<Department> findByCountryId(@PathVariable Long countryId) {
        return departmentFindByCountryIdCase.findByCountry(countryId);
    }
}
