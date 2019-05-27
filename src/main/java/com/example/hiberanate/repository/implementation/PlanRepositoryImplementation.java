package com.example.hiberanate.repository.implementation;

import com.example.hiberanate.entity.Plan;
import com.example.hiberanate.repository.PlanRepository;

public class PlanRepositoryImplementation extends SessionWorker implements PlanRepository<Plan> {
    @Override
    public Plan getPlanById(Integer id) {
        return getCurrentSession().get(Plan.class, id);
    }

    @Override
    public void updatePlan(Plan plan) {
        getCurrentSession().update(plan);
    }

    @Override
    public void mergePlan(Plan plan) {
        getCurrentSession().merge(plan);
    }
}
