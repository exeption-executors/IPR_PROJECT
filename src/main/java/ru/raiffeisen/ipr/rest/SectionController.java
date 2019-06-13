package ru.raiffeisen.ipr.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.raiffeisen.ipr.dto.*;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.entity.Section;
import ru.raiffeisen.ipr.mappers.ClientMapper;
import ru.raiffeisen.ipr.mappers.PlanMapper;
import ru.raiffeisen.ipr.mappers.SectionMapper;
import ru.raiffeisen.ipr.service.ClientService;
import ru.raiffeisen.ipr.service.PlanService;
import ru.raiffeisen.ipr.service.SectionService;

import java.io.PipedOutputStream;

@RestController
@RequestMapping("/section")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @Autowired
    private PlanService planService;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteSection(@RequestBody Section section){
        DeleteSectionByIdDTO deleteSectionByIdDTO = SectionMapper.deleteSectionByIdDTO(section);
        sectionService.deleteSectionById(section.getId());
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody PostSectionDTO postSectionDTO) {
        sectionService.postSection(postSectionDTO,planService);
    }

}
