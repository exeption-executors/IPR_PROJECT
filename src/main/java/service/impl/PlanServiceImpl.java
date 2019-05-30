package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PlanRepository;
import repository.PlanTaskRepository;
import service.PlanService;

import java.sql.Date;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanRepository planRepository;

    @Override
    public void createPlan(Long client_id, Date plan_date_start, Date plan_date_end) {
        planRepository.createPlan(client_id, plan_date_start, plan_date_end);
    }

    @Override
    public void deletePlanById(Long id) {
        planRepository.deletePlanById(id);
    }

    @Override
    public void updatePlan(Date plan_date_start, Date plan_date_end, Long id) {
        planRepository.updatePlan(plan_date_start, plan_date_end, id);
    }

    @Autowired
    private PlanTaskRepository planTaskRepository;
    @Override
    public void createPlanTask(Long plan_id, Date plan_tasks_date_end, String plan_tasks_description, String priority) {
        planTaskRepository.createPlanTask(plan_id, plan_tasks_date_end, plan_tasks_description, priority);
    }

    @Override
    public void deletePlanTaskById(Long id) {
        planTaskRepository.deletePlanTaskById(id);
    }

    @Override
    public void updatePlanTask(Date plan_tasks_date_end, String plan_tasks_description, String priority, Long id) {
        planTaskRepository.updatePlanTask(plan_tasks_date_end, plan_tasks_description, priority, id);
    }
}
