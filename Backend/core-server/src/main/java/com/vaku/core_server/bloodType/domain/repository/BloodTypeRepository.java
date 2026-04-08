package com.vaku.core_server.bloodType.domain.repository;

import com.vaku.core_server.bloodType.domain.model.BloodType;

import java.util.List;

public interface BloodTypeRepository {
    List<BloodType> findAll();
}
