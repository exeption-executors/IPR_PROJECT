package ru.raiffeisen.ipr.service;

import ru.raiffeisen.ipr.dto.CreatePointDTO;

public interface PointService {
    void postPoint(CreatePointDTO createPointDTO, SectionService sectionService);
    void deletePointById(Long id);
    void updatePointById(boolean pointIsDone, String pointDescription, Long id);
}
