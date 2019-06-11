package ru.raiffeisen.ipr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.repository.PlanRepository;
import ru.raiffeisen.ipr.repository.SectionRepository;
import ru.raiffeisen.ipr.repository.PointRepository;
import ru.raiffeisen.ipr.service.PlanService;

import java.sql.Date;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanRepository planRepository;

    @Override
    public void deletePlanById(Long id) {
        planRepository.deleteById(id);
    }

    @Override
    public Plan savePlan(Plan plan) {
        return planRepository.saveAndFlush(plan);
    }

    @Autowired
    private SectionRepository sectionRepository;
    @Override
    public void createSection(Long plan_id, Date section_date_end, String section_description, String priority) {
        sectionRepository.createSection(plan_id, section_date_end, section_description, priority);
    }

    @Override
    public void deleteSectionById(Long id) {
        sectionRepository.deleteSectionById(id);
    }

    @Override
    public void updateSection(Date section_date_end, String section_description, String priority, Long id) {
        sectionRepository.updateSection(section_date_end, section_description, priority, id);
    }

    @Autowired
    private PointRepository pointRepository;

    @Override
    public void createPoint(Long section_id, boolean point_is_done, String point_description) {
        pointRepository.createPoint(section_id, point_is_done, point_description);
    }

    @Override
    public void deletePoint(Long id) {
        pointRepository.deletePointById(id);
    }

    @Override
    public void updatePoint(boolean point_is_done, String point_description, Long id) {
        pointRepository.updatePoint(point_is_done, point_description, id);
    }
}
