package com.vaku.core_server.department.infraestructure.outbound.entity;

import com.vaku.core_server.country.infraestructure.outbound.entity.CountryEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "department")
public class DepartmentEntity {
    @Id
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity country;
}
