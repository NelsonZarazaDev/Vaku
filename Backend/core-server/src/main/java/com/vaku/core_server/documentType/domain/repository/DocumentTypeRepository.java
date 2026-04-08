package com.vaku.core_server.documentType.domain.repository;

import com.vaku.core_server.documentType.domain.model.DocumentType;

import java.util.List;

public interface DocumentTypeRepository {
    List<DocumentType> findByCountryId(Long countryId);
}
