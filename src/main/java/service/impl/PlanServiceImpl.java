package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import repository.PlanRepository;
import service.PlanService;

import java.sql.Date;

public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanRepository planRepository;

    @Override
    public void createPlan(Long client_id, Date plan_date_start, Date plan_date_end) {
        planRepository.createPlan(client_id, plan_date_start, plan_date_end);
    }
}
