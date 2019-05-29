package service;

import entity.Plan;

import java.sql.Date;

public interface PlanService {
    void createPlan(Integer client_id, Date plan_date_start, Date plan_date_end);
}
