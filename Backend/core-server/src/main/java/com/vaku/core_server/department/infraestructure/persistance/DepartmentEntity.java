package com.vaku.core_server.department.infraestructure.persistance;

import com.vaku.core_server.country.infraestructure.persistance.CountryEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
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
