package com.vaku.core_server.healthCenter.application.findAll;

import com.vaku.core_server.healthCenter.domain.model.HealthCenter;
import com.vaku.core_server.healthCenter.domain.repository.HealthCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HealthCenterFindAllCase {

    private final HealthCenterRepository healthCenterRepository;

    public List<HealthCenter> findAllHealthCenter() {
        return healthCenterRepository.findAll();
    }
}
