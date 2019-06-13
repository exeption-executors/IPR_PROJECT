package ru.raiffeisen.ipr.service;

import java.sql.Date;

import ru.raiffeisen.ipr.dto.PostSectionDTO;
import ru.raiffeisen.ipr.entity.Section;

import java.sql.Date;
import java.util.Optional;

public interface SectionService {
    void deleteSectionById(Long id);
    void updateSectionById(Date section_date_end, String section_description, String priority, Long id);
    void postSection(PostSectionDTO postSectionDTO, PlanService planService);
    Optional<Section> findById(Long id);
    Section saveSection (Section section);
}
