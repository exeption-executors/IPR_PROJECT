package ru.raiffeisen.ipr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.dto.CreatePartnerDTO;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.entity.Partner;
import ru.raiffeisen.ipr.entity.Section;
import ru.raiffeisen.ipr.mappers.PartnerMapper;
import ru.raiffeisen.ipr.repository.ClientRepository;
import ru.raiffeisen.ipr.repository.PartnerRepository;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.PartnerService;
import ru.raiffeisen.ipr.service.SectionService;

import javax.servlet.http.Part;
import java.util.*;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void postPartner(CreatePartnerDTO createPartnerDTO, SectionService sectionService, ClientService clientService) {
        Partner partner = PartnerMapper.fromPartnerDTOToPartnerEntity(createPartnerDTO);
        Section section = sectionService.findById(createPartnerDTO.getSection_id()).orElseThrow(RuntimeException::new);
        partner.setSection(section);
        Client client = clientService.findById(createPartnerDTO.getClient_id()).orElseThrow(RuntimeException::new);
        partner.setClient(client);
        partnerRepository.save(partner);
    }

    @Override
    public void deletePartnerById(Long id) {partnerRepository.deleteById(id);
    }

    @Override
    public void updatePartnerById(String requirements, Long id) {
        partnerRepository.updatePartner(requirements, id);
    }
}
