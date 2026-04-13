package com.vaku.core_server.healthCenter.infraestructure.controller;

import com.vaku.core_server.healthCenter.application.port.in.FindAllHealthCenterCase;
import com.vaku.core_server.healthCenter.infraestructure.controller.dto.HealthCenterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/healthCenter")
@RequiredArgsConstructor
public class HealthCenterController {
    private final FindAllHealthCenterCase findAllHealthCenterCase;

    @GetMapping
    public List<HealthCenterResponse> findAllHealtCenter() {
        return findAllHealthCenterCase.findAllHealthCenter();
    }
}
