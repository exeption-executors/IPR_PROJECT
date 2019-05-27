package com.example.hiberanate.service;


import com.example.hiberanate.entity.Plan;
import com.example.hiberanate.entity.PlanTasks;
import com.example.hiberanate.repository.implementation.PlanRepositoryImplementation;

import java.util.List;

public class PlanService {
    private static PlanRepositoryImplementation planRepository;

    public PlanService() {
        planRepository = new PlanRepositoryImplementation();
    }

    public void addPlanTasksToPlan(Plan plan, PlanTasks planTasks) {
        planRepository.openCurrentSessionWithTransaction();
        plan.addPlanTasksEntity(planTasks);
        planRepository.mergePlan(plan);
        planRepository.closeCurrentSessionWithTransaction();
    }



    public Plan findById(Integer id) {
        planRepository.openCurrentSession();
        Plan plan = planRepository.getPlanById(id);
        planRepository.closeCurrentSession();
        return plan;
    }

    public List<PlanTasks> getPlanTasksByPlan(Plan plan) {
        planRepository.openCurrentSession();
        List<PlanTasks> planTasks = plan.getPlanTasksEntities();
        planRepository.closeCurrentSession();
        return  planTasks;
    }
}
