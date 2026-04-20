package com.vaku.core_server.healthCenter.infraestructure.controller;

import com.vaku.core_server.healthCenter.application.port.in.CreateHealthCenterCase;
import com.vaku.core_server.healthCenter.application.port.in.FindAllHealthCenterCase;
import com.vaku.core_server.healthCenter.application.port.in.FindByIdHealthCenterCase;
import com.vaku.core_server.healthCenter.application.port.in.UpdateHealthCenterCase;
import com.vaku.core_server.healthCenter.infraestructure.controller.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/healthCenter")
@RequiredArgsConstructor
public class HealthCenterController {
    private final FindAllHealthCenterCase findAllHealthCenterCase;
    private final FindByIdHealthCenterCase findByIdHealthCenterCase;
    private final CreateHealthCenterCase createHealthCenterCase;
    private final UpdateHealthCenterCase updateHealthCenterCase;

    @GetMapping
    public List<HealthCenterResponse> findAllHealtCenter() {
        return findAllHealthCenterCase.findAllHealthCenter();
    }

    @GetMapping(path = "{id}")
    public FindByIdHealthCenterResponse findByIdHealtCenter(@PathVariable UUID id) {
        return findByIdHealthCenterCase.findById(id);
    }

    @PostMapping
    public CreateHealthCenterResponse create(@Valid @RequestBody CreateHealthCenterRequest healthCenter) {
        return createHealthCenterCase.create(healthCenter);
    }

    @PutMapping(path = "{id}")
    public UpdateHealthCenterResponse update(@PathVariable UUID id, @RequestBody UpdateHealthCenterRequest request) {
        return updateHealthCenterCase.update(id, request);
    }
}