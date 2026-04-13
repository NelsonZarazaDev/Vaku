package com.vaku.core_server.documentType.infraestructure.persistance;

import com.vaku.core_server.documentType.application.port.out.DocumentTypeRespositoryByCountryIdPort;
import com.vaku.core_server.documentType.infraestructure.controller.dto.DocumentTypeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaRepositoryAdapterDocumentType implements DocumentTypeRespositoryByCountryIdPort {

    private final SpringDateDocumentTypeRepository springDateDocumentTypeRepository;

    @Override
    public List<DocumentTypeResponse> findAllDocumentType(Long countryId) {
        return springDateDocumentTypeRepository.findByCountry_Id(countryId)
                .stream()
                .map(documentType -> new DocumentTypeResponse(documentType.getId(), documentType.getName(), documentType.getCode(), documentType.getMin_length(), documentType.getMax_length()))
                .toList();
    }
}
