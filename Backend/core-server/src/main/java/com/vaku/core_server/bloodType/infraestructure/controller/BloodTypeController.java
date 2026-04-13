package com.vaku.core_server.bloodType.infraestructure.controller;

import com.vaku.core_server.bloodType.application.port.in.FindAllBloodTypeCase;
import com.vaku.core_server.bloodType.infraestructure.controller.dto.BloodTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/bloodType")
@RequiredArgsConstructor
public class BloodTypeController {

    private final FindAllBloodTypeCase findAllBloodTypeCase;

    @GetMapping
    public List<BloodTypeResponse> findAllBloodType() {
        return findAllBloodTypeCase.findAllBloodType();
    }


}
