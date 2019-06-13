package ru.raiffeisen.ipr.service;

import ru.raiffeisen.ipr.dto.CreatePlanDTO;
import ru.raiffeisen.ipr.entity.Plan;

public interface GrandPostService {
    void createFullPlan(CreatePlanDTO createPlanDTO, ClientService clientService);
}
