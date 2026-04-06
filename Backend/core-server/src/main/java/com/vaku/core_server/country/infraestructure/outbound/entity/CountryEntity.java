package com.vaku.core_server.country.infraestructure.outbound.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country")
public class CountryEntity {
    @Id
    private Long id;
    private String name;
    private String cod_iso2;
    private String cod_iso3;
    private String phone_code;
}
