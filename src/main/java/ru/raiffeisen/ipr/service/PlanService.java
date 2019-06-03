package ru.raiffeisen.ipr.service;

import java.sql.Date;

public interface PlanService {
    void createPlan(Long client_id, Date plan_date_start, Date plan_date_end);
    void deletePlanById(Long id);
    void updatePlan(Date plan_date_start, Date plan_date_end, Long id);
    void createPlanTask(Long plan_id, Date plan_tasks_date_end, String plan_tasks_description, String priority);
    void deletePlanTaskById(Long id);
    void updatePlanTask(Date plan_tasks_date_end, String plan_tasks_description, String priority, Long id);
    void createTaskList(Long plan_tasks_id, boolean task_is_done, String task_description);
    void deleteTaskList(Long id);
    void updateTaskList(boolean task_is_done, String task_description, Long id);
}