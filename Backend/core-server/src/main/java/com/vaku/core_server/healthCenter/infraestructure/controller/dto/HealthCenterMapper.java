package com.vaku.core_server.healthCenter.infraestructure.controller.dto;

import com.vaku.core_server.city.infraestructure.persistence.CityEntity;
import com.vaku.core_server.healthCenter.infraestructure.persistence.HealthCenterEntity;

public class HealthCenterMapper {
    public static HealthCenterResponse toResponse(HealthCenterEntity dataResponse) {
        return new HealthCenterResponse(
                dataResponse.getId(),
                dataResponse.getName(),
                dataResponse.getCreatedAt(),
                dataResponse.getUpdateAt(),
                dataResponse.getCity().getId()
        );
    }

    public static FindByIdHealthCenterResponse toFindByIdResponse(HealthCenterEntity dataResponse) {
        return new FindByIdHealthCenterResponse(
                dataResponse.getId(),
                dataResponse.getName(),
                dataResponse.getStatus(),
                dataResponse.getCreatedAt(),
                dataResponse.getUpdateAt(),
                dataResponse.getDeleteAt(),
                dataResponse.getCity().getId()
        );
    }

    public static HealthCenterEntity toCreateEntity(
            CreateHealthCenterRequest request,
            CityEntity city
    ) {
        return HealthCenterEntity.builder()
                .name(request.getName())
                .status(request.getStatus())
                .city(city)
                .build();
    }

    public static CreateHealthCenterResponse toCreateResponse(HealthCenterEntity dataResponse) {
        return new CreateHealthCenterResponse(
                dataResponse.getId(),
                dataResponse.getName(),
                dataResponse.getStatus(),
                dataResponse.getCreatedAt(),
                dataResponse.getUpdateAt(),
                dataResponse.getCity().getId()
        );
    }

    public static UpdateHealthCenterResponse toUpdateResponse(HealthCenterEntity dataResponse) {
        return new UpdateHealthCenterResponse(
                dataResponse.getId(),
                dataResponse.getName(),
                dataResponse.getCreatedAt(),
                dataResponse.getUpdateAt(),
                dataResponse.getCity().getId()
        );
    }
}