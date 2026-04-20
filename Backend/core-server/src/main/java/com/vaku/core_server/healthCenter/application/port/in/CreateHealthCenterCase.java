package com.vaku.core_server.healthCenter.application.port.in;

import com.vaku.core_server.healthCenter.infraestructure.controller.dto.CreateHealthCenterRequest;
import com.vaku.core_server.healthCenter.infraestructure.controller.dto.CreateHealthCenterResponse;

public interface CreateHealthCenterCase {
    CreateHealthCenterResponse create(CreateHealthCenterRequest request);
}
