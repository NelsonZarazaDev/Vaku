package com.vaku.core_server.documentType.infraestructure.controller;

import com.vaku.core_server.documentType.application.port.in.FindAllDocumentTypeByCountryIdCase;
import com.vaku.core_server.documentType.infraestructure.controller.dto.DocumentTypeResponse;
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
    private final FindAllDocumentTypeByCountryIdCase findAllDocumentTypeByCountryIdCase;

    @GetMapping(path = "{countryId}")
    public List<DocumentTypeResponse> findAllDocumentTypeByCOuntryId(@PathVariable Long countryId){
        return findAllDocumentTypeByCountryIdCase.findAllDocumentType(countryId);
    }
}
