package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PlanRepository;
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
}
