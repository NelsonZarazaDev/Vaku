package com.vaku.core_server.healthCenter.infraestructure.inbound.controller;

import com.vaku.core_server.healthCenter.application.findAll.HealthCenterFindAllCase;
import com.vaku.core_server.healthCenter.domain.model.HealthCenter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/healthCenter")
@AllArgsConstructor
public class HealthCenterController {
    private final HealthCenterFindAllCase healthCenterFindAllCase;

    @GetMapping
    public List<HealthCenter> findAll() {
        return healthCenterFindAllCase.findAllHealthCenter();
    }
}
