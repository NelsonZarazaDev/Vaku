package com.vaku.core_server.bloodType.infraestructure.inbound.controller;

import com.vaku.core_server.bloodType.application.findAllBloodType.BloodTypeFindAllCase;
import com.vaku.core_server.bloodType.domain.model.BloodType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/bloodType")
@RequiredArgsConstructor
public class BloodTypeController {

    private final BloodTypeFindAllCase bloodTypeFindAllCase;

    @GetMapping
    public List<BloodType> findAll() {
        return bloodTypeFindAllCase.findAllBloodType();
    }
}
