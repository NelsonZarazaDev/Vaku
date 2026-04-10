package com.vaku.core_server.healthCenter.infraestructure.outbound.entity;

import com.vaku.core_server.city.infraestructure.outbound.entity.CityEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "health_center")
public class HealthCenterEntity {
    @Id
    private UUID id;
    private String name;
    private Boolean status;
    private String created_at;
    private String update_at;
    private String delete_at;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityEntity city;
}
