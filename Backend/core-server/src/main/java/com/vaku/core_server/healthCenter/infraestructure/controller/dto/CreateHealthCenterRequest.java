package com.vaku.core_server.healthCenter.infraestructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateHealthCenterRequest {
    private String name;
    private Boolean status;
    private int city_id;
}
