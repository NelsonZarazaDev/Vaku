package com.vaku.core_server.documentType.application.findByCountryId;

import com.vaku.core_server.documentType.domain.model.DocumentType;
import com.vaku.core_server.documentType.domain.repository.DocumentTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentTypeFindByCountryIdCase {
    private final DocumentTypeRepository documentTypeRepository;

    public List<DocumentType> findByCountryId(Long countryId) {
        return documentTypeRepository.findByCountryId(countryId);
    }
}
