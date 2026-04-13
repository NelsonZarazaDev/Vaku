package com.vaku.core_server.documentType.application.port.out;

import com.vaku.core_server.documentType.infraestructure.controller.dto.DocumentTypeResponse;

import java.util.List;

public interface DocumentTypeRespositoryByCountryIdPort {
    List<DocumentTypeResponse> findAllDocumentType(Long countryId);
}
