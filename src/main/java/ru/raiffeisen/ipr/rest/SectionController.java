package ru.raiffeisen.ipr.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.raiffeisen.ipr.dto.*;
import ru.raiffeisen.ipr.dto.DeleteSectionByIdDTO;
import ru.raiffeisen.ipr.dto.UpdateSectionDTO;
import ru.raiffeisen.ipr.entity.Section;
import ru.raiffeisen.ipr.mappers.SectionMapper;
import ru.raiffeisen.ipr.service.PlanService;
import ru.raiffeisen.ipr.service.SectionService;


@RestController
@RequestMapping("/section")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @Autowired
    private PlanService planService;

    /**----DELETE SECTION FUNCTION----**/
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteSection(@RequestBody DeleteSectionByIdDTO deleteSectionByIdDTO){
        sectionService.deleteSectionById(deleteSectionByIdDTO.getId());
    }

    /**----CREATE SECTION FUNCTION----**/
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public SectionReturnDTO createSection(@RequestBody PostSectionDTO postSectionDTO) {
        Section sectionAfterSave = sectionService.postSection(postSectionDTO,planService);

        System.out.println(sectionAfterSave);
        return SectionMapper.fromSectionEntityToSectionDTO(sectionAfterSave);
    }

    /**-----UPDATE SECTION FUNCTION----**/
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateSection(@RequestBody UpdateSectionDTO updateSectionDTO){
        Section section = SectionMapper.updateSectionDTO(updateSectionDTO);
        sectionService.updateSectionById(section.getSectionDateEnd(), section.getSectionDescription(),section.getPriority(),section.getId());
    }
}