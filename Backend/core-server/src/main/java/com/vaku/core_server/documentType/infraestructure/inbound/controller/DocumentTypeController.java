package com.vaku.core_server.documentType.infraestructure.inbound.controller;

import com.vaku.core_server.documentType.application.findByCountryId.DocumentTypeFindByCountryIdCase;
import com.vaku.core_server.documentType.domain.model.DocumentType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/documentType")
@RequiredArgsConstructor
public class DocumentTypeController {
    private final DocumentTypeFindByCountryIdCase documentTypeFindByCountryIdCase;

    @GetMapping(path = "{countryId}")
    public List<DocumentType> findByCountryId(@PathVariable Long countryId) {
        return documentTypeFindByCountryIdCase.findByCountryId(countryId);
    }
}
