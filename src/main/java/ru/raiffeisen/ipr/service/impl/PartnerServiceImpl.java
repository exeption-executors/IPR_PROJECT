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
import java.util.*;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void postPartner(CreatePartnerDTO createPartnerDTO, SectionService sectionService) {
        Partner partner = PartnerMapper.fromPartnerDTOToPartnerEntity(createPartnerDTO);

        Section section = sectionService.findById(createPartnerDTO.getSection_id()).orElseThrow(RuntimeException::new);

        partner.setSection(section);

        //Client clientOwner = clientRepository.findById(createPartnerDTO.getClient_id()).orElseThrow(RuntimeException::new);
        Client client1 = clientRepository.findByEmail(createPartnerDTO.getSupportEmail1());
        Client client2 = clientRepository.findByEmail(createPartnerDTO.getSupportEmail2());
        Client client3 = clientRepository.findByEmail(createPartnerDTO.getSupportEmail3());
        Client client4 = clientRepository.findByEmail(createPartnerDTO.getSupportEmail4());
        Client client5 = clientRepository.findByEmail(createPartnerDTO.getSupportEmail5());


        partner.setSupport(new HashSet<>(List.of(client1, client2, client3,client4,client5)));
        partnerRepository.save(partner);

        //clientOwner.addPartnerToClient(partner);
        //clientRepository.save(clientOwner);
    }

    @Override
    public void deletePartnerById(Long id) {partnerRepository.deleteById(id);
    }

    @Override
    public void updatePartnerById(String requirements, Long id) {
        partnerRepository.updatePartner(requirements, id);
    }
}
