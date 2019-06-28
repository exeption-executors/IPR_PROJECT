package ru.raiffeisen.ipr.service;

import ru.raiffeisen.ipr.dto.CreatePartnerDTO;

public interface PartnerService {
    void postPartner(CreatePartnerDTO createPartnerDTO, SectionService sectionService, ClientService clientService);
    void deletePartnerById(Long id);
    void updatePartnerById(String requirements, Long id);
}
