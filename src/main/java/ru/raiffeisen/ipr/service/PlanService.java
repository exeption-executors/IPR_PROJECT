package ru.raiffeisen.ipr.service;

import ru.raiffeisen.ipr.entity.Plan;

import java.sql.Date;

public interface PlanService {
    Plan savePlan (Plan plan);
    void deletePlanById(Long id);
    void createSection(Long plan_id, Date section_date_end, String section_description, String priority);
    void deleteSectionById(Long id);
    void updateSection(Date section_date_end, String section_description, String priority, Long id);
    void createTaskList(Long section_id, boolean task_is_done, String task_description);
    void deleteTaskList(Long id);
    void updateTaskList(boolean task_is_done, String task_description, Long id);
}