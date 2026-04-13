package com.vaku.core_server.bloodType.application.service;

import com.vaku.core_server.bloodType.application.port.in.FindAllBloodTypeCase;
import com.vaku.core_server.bloodType.application.port.out.BloodTypeRepositoryPort;
import com.vaku.core_server.bloodType.infraestructure.controller.dto.BloodTypeResponse;
import com.vaku.core_server.country.application.port.out.CountryRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BloodTypeService implements FindAllBloodTypeCase {

    private final BloodTypeRepositoryPort bloodTypeRepositoryPort;

    @Override
    public List<BloodTypeResponse> findAllBloodType() {
        return bloodTypeRepositoryPort.findAll();
    }
}
