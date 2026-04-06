package com.vaku.core_server.city.infraestructure.inbound.controller;

import com.vaku.core_server.city.application.findByDepartmentId.CityFindByDepartmentIdCase;
import com.vaku.core_server.city.domain.model.City;
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
    private final CityFindByDepartmentIdCase cityFindByDepartmentIdCase;

    @GetMapping(path = "{departmentId}")
    public List<City> findByDepartmentId(@PathVariable Long departmentId) {
        return cityFindByDepartmentIdCase.FindByDepartmentId(departmentId);
    }
}
