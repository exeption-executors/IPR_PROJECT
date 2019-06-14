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
import ru.raiffeisen.ipr.service.PartnerService;
import ru.raiffeisen.ipr.service.SectionService;

import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void postPartner(CreatePartnerDTO createPartnerDTO, SectionService sectionService) {
        Partner partner = PartnerMapper.fromPartnerDTOToPartnerEntity(createPartnerDTO);

        Section section = sectionService.findById(createPartnerDTO.getSection()).orElseThrow(RuntimeException::new);

        partner.setSection(section);

        Client client1 = clientRepository.findById(4l).orElseThrow(RuntimeException::new);
        Client client2 = clientRepository.findById(2l).orElseThrow(RuntimeException::new);
        Client client3 = clientRepository.findById(1l).orElseThrow(RuntimeException::new);

        partner.setSupport(new HashSet<>(List.of(client2, client3)));

        client1.addPartnerToClient(partner);
        clientRepository.save(client1);
    }
}
