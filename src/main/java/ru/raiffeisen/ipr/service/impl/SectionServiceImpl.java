package ru.raiffeisen.ipr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.dto.CreateSectionDTO;
import ru.raiffeisen.ipr.dto.PostSectionDTO;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.entity.Section;
import ru.raiffeisen.ipr.mappers.PlanMapper;
import ru.raiffeisen.ipr.mappers.SectionMapper;
import ru.raiffeisen.ipr.repository.SectionRepository;
import ru.raiffeisen.ipr.service.PlanService;
import ru.raiffeisen.ipr.service.SectionService;

import java.awt.*;
import java.sql.Date;
import java.util.Optional;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public void deleteSectionById(Long id) {
        sectionRepository.deleteSectionById(id);
    }

    @Override
    public void postSection(PostSectionDTO postSectionDTO, PlanService planService) {
        Section section = SectionMapper.fromSectionDTOToSectionEntity(postSectionDTO);
        Plan plan = planService.findById(postSectionDTO.getPlan_id()).orElseThrow(RuntimeException::new);
        plan.addSectionEntity(section);
        planService.savePlan(plan);
    }
}
