package com.vaku.core_server.documentType.domain.model;

import com.vaku.core_server.documentType.infraestructure.outbound.entity.DocumentTypeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class DocumentType {
    private UUID id;
    private String name;
    private String code;
    private Integer min_length;
    private Integer max_length;

    public DocumentType(DocumentTypeEntity documentTypeEntity) {
        this.id = documentTypeEntity.getId();
        this.name = documentTypeEntity.getName();
        this.code = documentTypeEntity.getCode();
        this.min_length = documentTypeEntity.getMin_length();
        this.max_length = documentTypeEntity.getMax_length();
    }
}
