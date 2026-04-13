package com.vaku.core_server.city.infraestructure.controller;

import com.vaku.core_server.city.application.port.in.FindAllCityByDepartmentIdCase;
import com.vaku.core_server.city.infraestructure.controller.dto.CityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {
    private final FindAllCityByDepartmentIdCase findAllCityByDepartmentIdCase;

    @GetMapping(path = "{departmentId}")
    public List<CityResponse> findAllDepartmentByCountryId(@PathVariable Long departmentId) {
        return findAllCityByDepartmentIdCase.findAllCityByDepartmentId(departmentId);
    }
}
