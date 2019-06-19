package ru.raiffeisen.ipr.service;

import ru.raiffeisen.ipr.dto.CreatePlanDTO;

public interface GrandPostService {
    void createFullPlan(CreatePlanDTO createPlanDTO, ClientService clientService);
}
