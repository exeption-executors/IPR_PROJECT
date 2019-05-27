package com.example.hiberanate.repository;

public interface PlanRepository<P> {
    P getPlanById(Integer id);
    void updatePlan(P plan);
    void mergePlan(P plan);
}
