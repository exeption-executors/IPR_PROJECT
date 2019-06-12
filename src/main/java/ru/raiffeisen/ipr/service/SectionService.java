package ru.raiffeisen.ipr.service;

import java.sql.Date;

public interface SectionService {
    void deleteSectionById(Long id);
    void updateSectionById(Date section_date_end, String section_description, String priority, Long id);
}
