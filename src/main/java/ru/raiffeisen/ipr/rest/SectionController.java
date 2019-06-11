package ru.raiffeisen.ipr.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.raiffeisen.ipr.dto.ClientDeleteByEmailDTO;
import ru.raiffeisen.ipr.dto.DeleteSectionByIdDTO;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.entity.Section;
import ru.raiffeisen.ipr.mappers.ClientMapper;
import ru.raiffeisen.ipr.mappers.SectionMapper;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.SectionService;

@RestController
@RequestMapping("/section")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteSection(@RequestBody Section section){
        DeleteSectionByIdDTO deleteSectionByIdDTO = SectionMapper.deleteSectionByIdDTO(section);
        sectionService.deleteSectionById(section.getId());
    }
}
