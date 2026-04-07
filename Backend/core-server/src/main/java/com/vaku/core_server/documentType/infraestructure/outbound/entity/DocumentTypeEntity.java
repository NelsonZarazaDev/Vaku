package com.vaku.core_server.documentType.infraestructure.outbound.entity;

import com.vaku.core_server.country.infraestructure.outbound.entity.CountryEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "document_type")
public class DocumentTypeEntity {
    @Id
    private UUID id;
    private String code;
    private String name;
    private String regex;
    private Integer min_length;
    private Integer max_length;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity country;
}
