package com.vaku.core_server.bloodType.infraestructure.outbound.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blood_type")
public class BloodTypeEntity {
    @Id
    private UUID id;
    private String name;
}
