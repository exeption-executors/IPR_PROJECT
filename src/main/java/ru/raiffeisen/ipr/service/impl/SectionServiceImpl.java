package ru.raiffeisen.ipr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.dto.CreateSectionDTO;
import ru.raiffeisen.ipr.dto.PostSectionDTO;
import ru.raiffeisen.ipr.dto.SectionReturnDTO;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.entity.Section;
import ru.raiffeisen.ipr.mappers.PlanMapper;
import ru.raiffeisen.ipr.mappers.SectionMapper;
import ru.raiffeisen.ipr.repository.PlanRepository;
import ru.raiffeisen.ipr.repository.SectionRepository;
import ru.raiffeisen.ipr.service.PlanService;
import ru.raiffeisen.ipr.service.SectionService;
import ru.raiffeisen.ipr.service.exeption.ClientNotFoundException;
import ru.raiffeisen.ipr.service.exeption.PlanNotFoundException;
import ru.raiffeisen.ipr.service.exeption.SectionNotFoundException;

import java.awt.*;
import java.sql.Date;
import java.util.Optional;

import java.sql.Date;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private PlanRepository planRepository;

    @Override
    public void deleteSectionById(Long id) {
        Optional<Section> section = sectionRepository.findById(id);
        section.orElseThrow(()-> {throw new SectionNotFoundException(id);
        });
        sectionRepository.delete(section.get());
    }

    @Override
    public SectionReturnDTO postSection(PostSectionDTO postSectionDTO, PlanService planService) {
        Section section = SectionMapper.fromSectionDTOToSectionEntity(postSectionDTO);
        Plan plan = planService.findById(postSectionDTO.getPlan_id())
                .orElseThrow(() -> { throw new PlanNotFoundException(postSectionDTO.getPlan_id());
                });
        plan.addSectionEntity(section);
        Plan planAfterSave = planService.updatePlan(plan);
        int lastAddedIndex = planAfterSave.getSectionEntities().size() - 1;
        SectionReturnDTO sectionReturnDTO = SectionMapper.fromSectionEntityToSectionDTO(planAfterSave.getSectionEntities().get(lastAddedIndex));
        return sectionReturnDTO;
    }

    @Override
    public void updateSectionById(Date section_date_end, String section_description, String priority, Long id) {
        Optional<Section> section = sectionRepository.findById(id);
        section.orElseThrow(() -> {
            throw new SectionNotFoundException(id);
        });
        sectionRepository.updateSection(section_date_end, section_description, priority, id);
    }

    @Override
    public Optional<Section> findById(Long id) {
        return sectionRepository.findById(id);
    }

    @Override
    public Section saveSection(Section section) {
        return sectionRepository.save(section);
    }
}