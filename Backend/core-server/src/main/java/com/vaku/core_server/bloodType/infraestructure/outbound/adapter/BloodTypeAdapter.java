package com.vaku.core_server.bloodType.infraestructure.outbound.adapter;

import com.vaku.core_server.bloodType.domain.model.BloodType;
import com.vaku.core_server.bloodType.domain.repository.BloodTypeRepository;
import com.vaku.core_server.bloodType.infraestructure.outbound.database.BloodTypeJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BloodTypeAdapter implements BloodTypeRepository {

    private final BloodTypeJpaRepository bloodTypeJpaRepository;

    @Override
    public List<BloodType> findAll() {
        return bloodTypeJpaRepository.findAll().stream().map(BloodType::new).toList();
    }
}
