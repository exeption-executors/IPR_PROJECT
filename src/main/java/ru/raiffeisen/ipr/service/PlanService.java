package ru.raiffeisen.ipr.service;

import ru.raiffeisen.ipr.entity.Plan;

import java.sql.Date;
import java.util.Optional;

public interface PlanService {
    void deletePlanById (Long id);
    Plan savePlan (Plan plan);
    Optional<Plan> findById(Long id);
}