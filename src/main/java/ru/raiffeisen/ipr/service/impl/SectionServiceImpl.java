package ru.raiffeisen.ipr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.repository.SectionRepository;
import ru.raiffeisen.ipr.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public void deleteSectionById(Long id) {
        sectionRepository.deleteSectionById(id);
    }
}
