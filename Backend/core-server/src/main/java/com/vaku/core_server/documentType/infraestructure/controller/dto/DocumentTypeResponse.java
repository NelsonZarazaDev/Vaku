package com.vaku.core_server.documentType.infraestructure.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class DocumentTypeResponse {
    private UUID id;
    private String name;
    private String code;
    private Integer min_length;
    private Integer max_length;
}