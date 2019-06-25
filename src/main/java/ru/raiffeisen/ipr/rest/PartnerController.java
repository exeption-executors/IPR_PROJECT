package ru.raiffeisen.ipr.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.raiffeisen.ipr.dto.CreatePartnerDTO;
import ru.raiffeisen.ipr.dto.DeletePartnerDTO;
import ru.raiffeisen.ipr.dto.UpdatePartnerDTO;
import ru.raiffeisen.ipr.entity.Partner;
import ru.raiffeisen.ipr.mappers.PartnerMapper;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.PartnerService;
import ru.raiffeisen.ipr.service.SectionService;

@RestController
@RequestMapping("/partner")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private SectionService sectionService;

    @Autowired
    private ClientService clientService;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createPartner(@RequestBody CreatePartnerDTO createPartnerDTO) {
        partnerService.postPartner(createPartnerDTO, sectionService, clientService);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deletePartner(@RequestBody DeletePartnerDTO deletePartnerDTO){
        partnerService.deletePartnerById(deletePartnerDTO.getId());
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updatePartner(@RequestBody UpdatePartnerDTO updatePartnerDTO) {
        Partner partner = PartnerMapper.updatePartnerDTO(updatePartnerDTO);
        partnerService.updatePartnerById(partner.getRequirements(), partner.getId());
    }
}
