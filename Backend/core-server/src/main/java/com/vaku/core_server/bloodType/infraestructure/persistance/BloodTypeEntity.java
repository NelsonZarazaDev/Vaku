package com.vaku.core_server.bloodType.infraestructure.persistance;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blood_type")
public class BloodTypeEntity {
    @Id
    private UUID id;
    private String name;
}
