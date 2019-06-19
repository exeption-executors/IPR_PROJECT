package ru.raiffeisen.ipr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.raiffeisen.ipr.entity.Plan;
import ru.raiffeisen.ipr.repository.PlanRepository;
import ru.raiffeisen.ipr.repository.SectionRepository;
import ru.raiffeisen.ipr.repository.PointRepository;
import ru.raiffeisen.ipr.service.PlanService;

import java.sql.Date;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;

    @Override
    public void deletePlanById(Long id) {
        planRepository.deleteById(id);
    }

    @Override
    public Plan savePlan(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public Optional<Plan> findById(Long id) {
       return planRepository.findById(id);
    }
}
