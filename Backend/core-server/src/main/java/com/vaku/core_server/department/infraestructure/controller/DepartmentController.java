package com.vaku.core_server.department.infraestructure.controller;

import com.vaku.core_server.department.application.port.in.FindAllDepartmentByCountryIdCase;
import com.vaku.core_server.department.infraestructure.controller.dto.DepartmentResponse;
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
    private final FindAllDepartmentByCountryIdCase findAllDepartmentByCountryIdCase;

    @GetMapping(path = "{countryId}")
    public List<DepartmentResponse> findAllDepartmentByCountryId(@PathVariable Long countryId) {
        return findAllDepartmentByCountryIdCase.findAllDepartmentByCountryId(countryId);
    }
}
