package com.vaku.core_server.documentType.application.service;

import com.vaku.core_server.documentType.application.port.in.FindAllDocumentTypeByCountryIdCase;
import com.vaku.core_server.documentType.application.port.out.DocumentTypeRespositoryByCountryIdPort;
import com.vaku.core_server.documentType.infraestructure.controller.dto.DocumentTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentTypeByCountryIdService implements FindAllDocumentTypeByCountryIdCase {

    private final DocumentTypeRespositoryByCountryIdPort documentTypeRespositoryByCountryIdPort;

    @Override
    public List<DocumentTypeResponse> findAllDocumentType(Long countryId) {
        return documentTypeRespositoryByCountryIdPort.findAllDocumentType(countryId);
    }
}
