package ru.raiffeisen.ipr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.entity.Client;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.repository.PlanRepository;
import ru.raiffeisen.ipr.service.PlanService;
import ru.raiffeisen.ipr.service.exeption.ClientNotFoundException;
import ru.raiffeisen.ipr.service.exeption.PlanNotFoundException;

import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public void deletePlanById(Long id) {
        Optional<Plan> plan = planRepository.findById(id);
        plan.orElseThrow(() -> {
            throw new PlanNotFoundException(id);
        });
        planRepository.delete(plan.get());
    }

    @Override
    public Plan updatePlan(Plan plan) {
        Optional<Plan> planFromDB = planRepository.findById(plan.getId());
        planFromDB.orElseThrow(() -> {
            throw new PlanNotFoundException(plan.getId());
        });
        return planRepository.save(plan);
    }

    @Override
    public Optional<Plan> findById(Long id) {
       return planRepository.findById(id);
    }
}
