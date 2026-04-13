package com.vaku.core_server.bloodType.infraestructure.persistance;

import com.vaku.core_server.bloodType.application.port.out.BloodTypeRepositoryPort;
import com.vaku.core_server.bloodType.infraestructure.controller.dto.BloodTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaRepositoryAdapterBloodType implements BloodTypeRepositoryPort {

    private final SpringDateBloodTypeRepository springDateBloodTypeRepository;

    @Override
    public List<BloodTypeResponse> findAll() {
        return springDateBloodTypeRepository.findAll()
                .stream()
                .map(bloodType -> new BloodTypeResponse(bloodType.getId(), bloodType.getName()))
                .toList();
    }
}
