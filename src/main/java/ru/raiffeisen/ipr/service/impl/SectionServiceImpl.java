package ru.raiffeisen.ipr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.repository.SectionRepository;
import ru.raiffeisen.ipr.service.SectionService;

import java.sql.Date;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public void deleteSectionById(Long id) {
        sectionRepository.deleteSectionById(id);
    }

    @Override
    public void updateSectionById(Date section_date_end, String section_description, String priority, Long id) {
        sectionRepository.updateSection(section_date_end, section_description, priority, id);
    }
}
