package ru.raiffeisen.ipr.service;

import ru.raiffeisen.ipr.entity.Plan;

import java.sql.Date;
import java.util.Optional;

public interface PlanService {
    void deletePlanById (Long id);
    Plan savePlan (Plan plan);
    void deleteSectionById(Long id);
    void updateSection(Date section_date_end, String section_description, String priority, Long id);
    void createPoint(Long section_id, boolean point_is_done, String point_description);
    void deletePoint(Long id);
    void updatePoint(boolean point_is_done, String point_description, Long id);
    Optional<Plan> findById(Long id);
}