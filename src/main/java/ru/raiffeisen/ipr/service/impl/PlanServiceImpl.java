package ru.raiffeisen.ipr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.repository.PlanRepository;
import ru.raiffeisen.ipr.repository.PlanTaskRepository;
import ru.raiffeisen.ipr.repository.TasksListRepository;
import ru.raiffeisen.ipr.service.PlanService;

import java.sql.Date;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanRepository planRepository;

    @Override
    public Plan savePlan(Plan plan) {
        return planRepository.saveAndFlush(plan);
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

    @Autowired
    private TasksListRepository tasksListRepository;

    @Override
    public void createTaskList(Long plan_tasks_id, boolean task_is_done, String task_description) {
        tasksListRepository.createTaskList(plan_tasks_id, task_is_done, task_description);
    }

    @Override
    public void deleteTaskList(Long id) {
        tasksListRepository.deleteTaskListById(id);
    }

    @Override
    public void updateTaskList(boolean task_is_done, String task_description, Long id) {
        tasksListRepository.updateTaskList(task_is_done, task_description, id);
    }

    @Override
    public void deletePlanById(Long id) {
        planRepository.deleteById(id);
    }
}
