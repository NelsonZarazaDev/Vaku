package com.vaku.core_server.healthCenter.infraestructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateHealthCenterRequest {
    private String name;
    private Boolean status;
}
