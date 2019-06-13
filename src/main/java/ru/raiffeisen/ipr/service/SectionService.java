package ru.raiffeisen.ipr.service;

import ru.raiffeisen.ipr.dto.PostSectionDTO;
import ru.raiffeisen.ipr.entity.Section;

import java.sql.Date;
import java.util.Optional;

public interface SectionService {
    void deleteSectionById(Long id);
//    Section postSection(Section section);

    void postSection(PostSectionDTO postSectionDTO, PlanService planService);
}
