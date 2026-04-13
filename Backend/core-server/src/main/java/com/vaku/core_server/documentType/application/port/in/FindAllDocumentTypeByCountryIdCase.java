package com.vaku.core_server.documentType.application.port.in;

import com.vaku.core_server.documentType.infraestructure.controller.dto.DocumentTypeResponse;

import java.util.List;

public interface FindAllDocumentTypeByCountryIdCase {
    List<DocumentTypeResponse> findAllDocumentType(Long countryId);
}
