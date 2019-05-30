package service;

import entity.Plan;

import java.sql.Date;

public interface PlanService {
    void createPlan(Long client_id, Date plan_date_start, Date plan_date_end);
    void deletePlanById(Long id);
    void updatePlan(Date plan_date_start, Date plan_date_end, Long id);
    void createPlanTask(Long plan_id, Date plan_tasks_date_end, String plan_tasks_description, String priority);
    void deletePlanTaskById(Long id);
    void updatePlanTask(Date plan_tasks_date_end, String plan_tasks_description, String priority, Long id);
}
