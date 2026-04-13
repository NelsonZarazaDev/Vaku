package com.vaku.core_server.city.infraestructure.persistence;

import com.vaku.core_server.department.infraestructure.persistance.DepartmentEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
public class CityEntity {
    @Id
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;
}
