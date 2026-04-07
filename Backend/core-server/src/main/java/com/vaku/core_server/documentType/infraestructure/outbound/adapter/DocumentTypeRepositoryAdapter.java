package com.vaku.core_server.documentType.infraestructure.outbound.adapter;

import com.vaku.core_server.documentType.domain.model.DocumentType;
import com.vaku.core_server.documentType.domain.repository.DocumentTypeRepository;
import com.vaku.core_server.documentType.infraestructure.outbound.database.DocumentTypeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class DocumentTypeRepositoryAdapter implements DocumentTypeRepository {
    private final DocumentTypeJpaRepository documentTypeJpaRepository;

    @Override
    public List<DocumentType> findByCountryId(Long countryId) {
        return documentTypeJpaRepository.findByCountry_id(countryId).stream()
                .map(DocumentType::new)
                .toList();
    }
}
