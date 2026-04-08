package com.vaku.core_server.bloodType.application.findAllBloodType;

import com.vaku.core_server.bloodType.domain.model.BloodType;
import com.vaku.core_server.bloodType.domain.repository.BloodTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BloodTypeFindAllCase {

    private final BloodTypeRepository bloodTypeRepository;

    public List<BloodType> findAllBloodType() {
        return bloodTypeRepository.findAll();
    }
}
