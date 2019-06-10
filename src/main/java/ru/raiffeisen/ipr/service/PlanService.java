package ru.raiffeisen.ipr.service;

import ru.raiffeisen.ipr.entity.Plan;

import java.sql.Date;

public interface PlanService {
    Plan savePlan (Plan plan);
    void deletePlanById(Long id);
    void createPlanTask(Long plan_id, Date plan_tasks_date_end, String plan_tasks_description, String priority);
    void deletePlanTaskById(Long id);
    void updatePlanTask(Date plan_tasks_date_end, String plan_tasks_description, String priority, Long id);
    void createTaskList(Long plan_tasks_id, boolean task_is_done, String task_description);
    void deleteTaskList(Long id);
    void updateTaskList(boolean task_is_done, String task_description, Long id);
}